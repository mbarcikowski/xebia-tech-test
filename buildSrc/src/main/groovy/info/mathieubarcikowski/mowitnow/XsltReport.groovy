package info.mathieubarcikowski.mowitnow

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*

class XsltReport extends DefaultTask {
    @InputFile
    @Optional
    File inputFile
    @InputFile
    File xslStyleFile
    @Input
    @Optional
    Map<String, String> params = [:]
    @OutputFile
    File outputFile

    XsltReport() {
        onlyIf {
            inputFile.exists()
        }
    }

    @TaskAction
    void start() {
        ant.xslt(in: inputFile, style: xslStyleFile, out: outputFile) {
            params.each { key, value ->
                ant.param(name: key, expression: value)
            }
        }
    }
}