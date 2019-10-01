package jmx

import java.lang.management.*

class JvmMont {
    static void main(String[] args){
        //  系统信息
        def os = ManagementFactory.operatingSystemMXBean
        println """ OPERATING  SYSTEM:
                  OS architechture = $os.arch
                  OS name = $os.name
                  OS version = $os.version
                  OS processors = $os.availableProcessors
"""
        //
        def rt = ManagementFactory.runtimeMXBean
        println """ RUNTIME:
                Runtime name = $rt.name
                Runtime spec name = $rt.specName
                Runtime vendor = $rt.specVendor
                Runtime spec bersion = $rt.specVersion
                Runtime management spec version = $rt.managementSpecVersion
                
"""
        def mem = ManagementFactory.memoryMXBean
        def heapUsage = mem.heapMemoryUsage
        def nonHeapUsage = mem.nonHeapMemoryUsage

        println """ 
        Heap STORAGE:
            Memory committed = ${heapUsage.committed/1024/1024} MB
            Memory init  = $heapUsage.init
            Memory max = ${heapUsage.max/1024/1024} MB
            Memory user = $heapUsage.used 
        NON-HEAP STORAGE:
            Non-heap memory committed = $nonHeapUsage.committed
            Non-heap memory init = $nonHeapUsage.init
            Non-heap memory max = $nonHeapUsage.max
            Non-heap memory used = $nonHeapUsage.used     
"""
        println "GARBAGE COLLECTION:"
        ManagementFactory.garbageCollectorMXBeans.each {gc->
            println "   name = $gc.name"
            println "   collection count = $gc.collectionCount"
            println "   collection time = $gc.collectionTime"
            String[] mpoolNames = gc.memoryPoolNames
            mpoolNames.each {
                mpoolName -> println " mpool name = $mpoolName"
            }
        }



    }

}