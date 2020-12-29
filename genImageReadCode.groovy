import java.nio.file.Files

//
// 清空IDEA的所有缓存
//

def code(String dir, String prefix) {

    // 获取当前文件夹所在目录
    def cur_dir = new File(getClass().protectionDomain.codeSource.location.path).parent
    def resources = "${cur_dir}/resources/${dir}"

    new File(resources).listFiles().each {
        def filename = it.name
        println "Image ${prefix}_${filename.toLowerCase().substring(0, filename.indexOf("."))} = ImageRead.read(\"${dir}/${filename}\");\n"
    }

}

code("/ui/moon&sun&star", "terraria")

