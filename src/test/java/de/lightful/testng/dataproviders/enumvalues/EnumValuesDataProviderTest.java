package de.lightful.testng.dataproviders.enumvalues;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

@Test
public class EnumValuesDataProviderTest {

  private Map<ExampleEnum, Integer> allExpectedEnumLiterals;

  @BeforeClass
  public void initExpectedEnumLiterals() {
    allExpectedEnumLiterals = new HashMap<ExampleEnum, Integer>(ExampleEnum.values().length);
    for (ExampleEnum expectedEnumValue : ExampleEnum.values()) {
      allExpectedEnumLiterals.put(expectedEnumValue, 0);
    }
  }

  @AfterClass
  public void verifyEachEnumLiteralPassedOnce() {
    for (ExampleEnum expectedEnumValue : ExampleEnum.values()) {
      assertThat(allExpectedEnumLiterals.get(expectedEnumValue)).as("Number of method calls for '" + expectedEnumValue + "'").isEqualTo(1);
    }
  }

  @Test(dataProviderClass = EnumValuesDataProvider.class, dataProvider = "getAllValues")
  @ProvideEnumValuesOf(ExampleEnum.class)
  public void takeEachEnumLiteralAsParameter(ExampleEnum enumLiteral) {
    allExpectedEnumLiterals.put(enumLiteral, allExpectedEnumLiterals.get(enumLiteral) + 1);
  }
}
