package de.lightful.testng.dataproviders.fromenum;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class GenericDataProvider {

  @DataProvider
  public static Object[][] enumValues(Method testMethod) {
    EnumValuesFrom enumValuesFromAnnotation = testMethod.getAnnotation(EnumValuesFrom.class);
    Class<? extends Enum> sourceOfLiterals = enumValuesFromAnnotation.value();
    Enum[] enumLiterals = sourceOfLiterals.getEnumConstants();
    return createArrayContainingLiterals(enumLiterals);
  }

  private static Object[][] createArrayContainingLiterals(Enum[] enumLiterals) {
    Object[][] resultArray = new Object[enumLiterals.length][];
    for (int i = 0; i < enumLiterals.length; i++) {
      resultArray[i] = new Enum[] {enumLiterals[i]};
    }
    return resultArray;
  }
}
