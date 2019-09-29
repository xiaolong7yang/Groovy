import groovy.xml.MarkupBuilder

class HelloWorld {
    static void main(String[] args) {
        println('Hello World')
        def xml = new MarkupBuilder()
        printContinue()
        defaultParameter(2,3)
        println(returnStringInfo());
    }

     static void printContinue(){
        int[] array = [0,1,2,3];
        for(int i in array) {
            if(i == 2){
                break;
            }
            println(i);

        }
    }

    static void defaultParameter(int a , int b = 2,int c = 3){
        int sum  = a+b+c
        println(sum)
    }

    static String returnStringInfo(){
        return "My MethodName is returnStringInfo "
    }
}