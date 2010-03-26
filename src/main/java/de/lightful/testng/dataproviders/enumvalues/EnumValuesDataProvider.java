package de.lightful.testng.dataproviders.enumvalues;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class EnumValuesDataProvider {

  @DataProvider
  public static Object[][] getAllValues(Method testMethod) {
    ProvideEnumValuesOf provideEnumValuesOfAnnotation = testMethod.getAnnotation(ProvideEnumValuesOf.class);
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
