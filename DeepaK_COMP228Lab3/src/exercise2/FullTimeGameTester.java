package exercise2;

 class FullTimeGameTester extends GameTester {

    private static final int BASE_SALARY = 3000;
     public FullTimeGameTester(String name) {
         super(name, true);
     }

     @Override
     public int determineSalary() {
         return BASE_SALARY;
     }

}//end class
