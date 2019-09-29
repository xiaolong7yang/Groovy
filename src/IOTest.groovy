class IOTest {
    static void main(String[] args) {
        new File("D:\\Code\\GroovyTest\\src\\Example.txt").eachLine {
            line -> println "line:$line"
        }
        File file = new File("D:\\Code\\GroovyTest\\src\\Example.txt")
        println file.text;
        new File("D:\\Code\\GroovyTest\\src\\", "Example.txt").withWriter('UTF-8') {
            writer -> writer.writeLine 'Hello World'
        }
        // 写入文件
        File writerFile = new File("D:\\Code\\GroovyTest\\src\\Example.txt")
        println writerFile.text;

        // 文件长度
        println "The File ${writerFile.absolutePath} has ${file.length()} bytes ";

        // 测试文件是否是目录
        println "File? ${file.isFile()}"
        println "Directory? ${file.isDirectory()}"

        // 创建目录
        def srcDirectory = new File('D:\\Code\\GroovyTest\\srcDirectory')
        srcDirectory.mkdir()
        srcDirectory.deleteOnExit()
        // 复制文件
        def dst = new File("D:\\Code\\GroovyTest\\src\\Example2.txt")
        dst << file.text
        // 获取目录内容
        def rootFiles = new File("src").listRoots();
        rootFiles.each {
            rootFile ->println rootFile.absolutePath
        }
       // showDirectorFiles(".")
        showDirectorAndFile(".")
    }
    // 显示文件夹里的文件
    static void showDirectorFiles(def path){
        new  File(path).eachFile (){
            file->println( file.getAbsoluteFile())
        }
    }
    // 递归显示所有
    static void showDirectorAndFile(def path){
        new File(path).eachFileRecurse (){
            file -> println(file.getAbsolutePath())
        }
    }
}
