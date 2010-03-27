/******************************************************************************
 * Copyright (c) 2010 Ansgar Konermann                                        *
 *                                                                            *
 * Licensed under the Apache License, Version 2.0 (the "License");            *
 * you may not use this file except in compliance with the License.           *
 * You may obtain a copy of the License at                                    *
 *                                                                            *
 *     http://www.apache.org/licenses/LICENSE-2.0                             *
 *                                                                            *
 * Unless required by applicable law or agreed to in writing, software        *
 * distributed under the License is distributed on an "AS IS" BASIS,          *
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.   *
 * See the License for the specific language governing permissions and        *
 * limitations under the License.                                             *
 ******************************************************************************/

package de.lightful.testng.dataproviders;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class EnumValuesDataProvider {

  @DataProvider
  public static Object[][] getAll(Method testMethod) {
    EnumValuesOf provideEnumValuesOfAnnotation = testMethod.getAnnotation(EnumValuesOf.class);
    Class<? extends Enum> sourceOfLiterals = provideEnumValuesOfAnnotation.value();
    Enum[] enumLiterals = sourceOfLiterals.getEnumConstants();
    return createArrayContainingAllEnumValues(enumLiterals);
  }

  private static Object[][] createArrayContainingAllEnumValues(Enum[] enumLiterals) {
    Object[][] resultArray = new Object[enumLiterals.length][];
    for (int i = 0; i < enumLiterals.length; i++) {
      resultArray[i] = new Enum[] {enumLiterals[i]};
    }
    return resultArray;
  }
}
