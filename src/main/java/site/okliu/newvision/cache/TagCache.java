package site.okliu.newvision.cache;

import site.okliu.newvision.dto.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {

    private static List<TagDTO> tagDTOS = new ArrayList<>();

    static{
        TagDTO frontEnd  = new TagDTO();
        frontEnd.setCategroyName("前端");
        frontEnd.setTags(Arrays.asList("javascript","前端","vue.js","css","html","html5","node.js","jquery","css3","es6",
                "typescript","react.js","chrome","npm","bootstrap","sass","less","chrome-devtools","firefox","angular",
                "coffeescript","safari","postcss","postman","fiddler","yarn","webkit","firebug","edge"));
        tagDTOS.add(frontEnd);

        TagDTO backEnd = new TagDTO();
        backEnd.setCategroyName("后端");
        backEnd.setTags(Arrays.asList("php","java","node.js","python","c++","c","golang","spring","django","springboot",
                "后端","flask","c#","swoole","ruby","asp.net","ruby-on-rails","scala","rust","lavarel","爬虫"));
        tagDTOS.add(backEnd);

        TagDTO mobile = new TagDTO();
        mobile.setCategroyName("移动端");
        mobile.setTags(Arrays.asList("java","android","ios","objective-c","小程序","swift","react-native","xcode",
                "android-studio","webapp","flutter","kotlin"));
        tagDTOS.add(mobile);

        TagDTO db = new TagDTO();
        db.setCategroyName("数据库");
        db.setTags(Arrays.asList("mysql","redis","mongodb","sql","数据库","json","elasticsearch","nosql",
                "memcached","postgresql","sqlite","mariadb"));
        tagDTOS.add(db);

        TagDTO devOps = new TagDTO();
        devOps.setCategroyName("运维");
        devOps.setTags(Arrays.asList("linux","nginx","docker","apache","centos","ubuntu","服务器","负载均衡",
                "运维","ssh","vagrant","容器","jenkins","devops","debian","fabric"));
        tagDTOS.add(devOps);

        TagDTO ai = new TagDTO();
        ai.setCategroyName("人工智能");
        ai.setTags(Arrays.asList("算法","机器学习","人工智能","深度学习","数据挖掘","tensorflow","神经网络","图像识别",
                "人脸识别","自然语言处理","机器人","pytorch","自动驾驶"));
        tagDTOS.add(ai);

        TagDTO tools = new TagDTO();
        tools.setCategroyName("工具");
        tools.setTags(Arrays.asList("git","github","macos","visual-studio-code","windows","vim","sublime-text","intellij-idea",
                "eclipse","phpstorm","webstorm","编辑器","svn","visual-studio","pycharm","emacs"));
        tagDTOS.add(tools);

        TagDTO others = new TagDTO();
        others.setCategroyName("其他");
        others.setTags(Arrays.asList("程序员","http","码农新视界","https","安全","websocket","restful","xss",
                "区块链","csrf","graphql","rpc","比特币","以太坊","udp","智能合约","其他"));
        tagDTOS.add(others);

    }

    /**
     * 返回标签集
     * @return
     */
    public static List<TagDTO> get(){
        return tagDTOS;
    }

    /**
     * 返回所有不合法的标签
     * @param tag
     * @return
     */
    public static String invalidTag(String tag){
        String[] split = tag.split(",");
        List<String> tagList = tagDTOS.stream().flatMap(t -> t.getTags().stream()).collect(Collectors.toList());
        return Arrays.stream(split).filter(t->!tagList.contains(t)).collect(Collectors.joining(","));
    }

}
