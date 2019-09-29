/**
 * 闭包
 */
class ClosureTest {
    static void main(String[] args){
        //closure 就是一个闭包
        def closure = {println "Hello World"};
        closure.call();
        // 带形参的闭包
        def closure1 = {param->println "Hello ${param}"};
        closure1.call("World")
        // it关键字
        def closure2 = {println "Heloo ${it}"}
        closure2.call("World")
        // 闭包和变量
        def str1 = "Hello";
        def closure3 = {param-> println "${str1} ${param}"}
        closure3.call("World");
        str1  = "Welcome"
        closure3.call("World")
        // 传入一个闭包
        ClosureTest.display(closure3)
        // 集合字符串中的闭包
        def lst = [11,12,13,14]
        lst.each {println it}
        // 映射闭包
        def mp = ["TopicName":"Maps","TopicDescription":"Methods in Maps"]
        mp.each{println it}
        println "-----------"
        mp.each{println "${it.key} maps to ${it.value} "}

        def lst1 = [1,2,3,4]
        lst1.each {println it}
        println("The List will only display those numbers which are divisible by 2")
        lst1.each {num->if(num%2==0)println num}

    }
    // 在方法中使用闭包
    def static display(clo){
        clo.call("Inner");
    }

}
