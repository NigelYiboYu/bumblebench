/*******************************************************************************
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/

package net.adoptopenjdk.bumblebench.humble;

import net.adoptopenjdk.bumblebench.core.HumbleBench;

public final class NewStringBuilderWithCapacityBench extends HumbleBench {

	public static final int STRING_CAPACITY = option("stringCapacity", 32);

	public StringBuilder[] _escape = new StringBuilder[8192];

	public NewStringBuilderWithCapacityBench() { super(Workload.class); }

	@Override
	protected final void setup(int numIterations) {
		if (_escape.length < numIterations) {
			_escape = new StringBuilder[numIterations];
		}
	}

	public static class Workload extends AbstractWorkload {
		@Override
		public void doBatch(HumbleBench bench0, int numIterations) {
			NewStringBuilderWithCapacityBench bench =
				(NewStringBuilderWithCapacityBench)bench0;

			StringBuilder[] escape = bench._escape;
			int capacity = STRING_CAPACITY;

			for (int i = 0; i < numIterations; i++) {
				escape[i] = new StringBuilder(capacity);
			}
		}
	}

}
