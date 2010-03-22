package net.itikko.testng.dataproviders.FromEnum;

import org.testng.annotations.Test;

@Test
public class UseEnumValuesTest {

  @Test(dataProviderClass = GenericDataProvider.class, dataProvider = "enumValues")
  @EnumValuesFrom(ExampleEnum.class)
  public void testAllEnums(ExampleEnum enumLiteral) {
    System.out.println("enum literal: " + enumLiteral.name());
  }
}
