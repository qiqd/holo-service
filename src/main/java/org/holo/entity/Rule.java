package org.holo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("rule")
@Schema(description = "爬虫规则配置")
public class Rule {

  private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36 Edg/144.0.0.0";

  @Id
  private String id;

  @Schema(description = "创建该规则的用户 ID", example = "64f0c0a0f0a0f0a0f0a0f0a0")
  private String userId = "";

  @Schema(description = "规则名称(通常为网站名称)", example = "示例网站")
  private String name = "";

  @Schema(description = "规则baseUrl(通常是网站的域名)", example = "https://example.com")
  private String baseUrl = "";

  @Schema(description = "规则logoUrl(通常是网站的logo)", example = "https://example.com/logo.png")
  private String logoUrl = "";

  @Schema(description = "是否使用WebView(默认false)", example = "false")
  private Boolean useWebView = false;

  @Schema(description = "规则版本号", example = "1.0")
  private String version = "1.0";

  @Schema(description = "搜索Url(通常是网站的搜索页面)", example = "/search")
  private String searchUrl = "";

  @Schema(description = "搜索请求方法(默认get)", example = "get")
  private String searchRequestMethod = "get";

  @Schema(description = "搜索请求体(通常是网站的搜索页面的请求体)")
  private Map<String, String> searchRequestBody = Map.of();

  @Schema(description = "搜索请求头部(通常是网站的搜索页面的请求头部)")
  private Map<String, String> searchRequestHeaders = Map.of("User-Agent", DEFAULT_USER_AGENT);

  @Schema(description = "是否是完整的搜索Url(如果是,则不与 baseUrl 拼接,否则拼接)", example = "false")
  private Boolean fullSearchUrl = false;

  @Schema(description = "超时时间(默认5秒)", example = "5")
  private Integer timeout = 5;

  @Schema(description = "搜索选择器(通常是搜索结果的列表)", example = ".search-results li")
  private String searchSelector = "";

  @Schema(description = "搜索图片选择器(通常是搜索结果的列表中的每一项的图片,一般是一个img标签)", example = "img")
  private String itemImgSelector = "";

  @Schema(description = "是否是图片选择器中的src属性(如果是,则图片选择器中的src属性是图片的url,否则是data-original属性)", example = "true")
  private Boolean itemImgFromSrc = true;

  @Schema(description = "搜索标题选择器(通常是搜索结果的列表中的每一项的标题,一般是一个a标签)", example = "h3 a")
  private String itemTitleSelector = "";

  @Schema(description = "MediaId选择器(通常是搜索结果的列表中的每一项的Id,一般是一个a标签)", example = "a[data-id]")
  private String itemIdSelector = "";

  @Schema(description = "搜索类型选择器(通常是搜索结果的列表中的每一项的内容的类型)", example = ".genre")
  private String itemGenreSelector = "";

  @Schema(description = "详情Url(通常是网站的详情页面)", example = "/detail/{id}")
  private String detailUrl = "";

  @Schema(description = "详情请求方法(默认get)", example = "get")
  private String detailRequestMethod = "get";

  @Schema(description = "详情请求体(通常是网站的详情页面的请求体)")
  private Map<String, String> detailRequestBody = Map.of();

  @Schema(description = "详情请求头部(通常是网站的详情页面的请求头部)")
  private Map<String, String> detailRequestHeaders = Map.of("User-Agent", DEFAULT_USER_AGENT);

  @Schema(description = "是否是完整的详情Url(如果是,则不与 baseUrl 拼接,否则拼接)", example = "false")
  private Boolean fullDetailUrl = false;

  @Schema(description = "路线选择器(该视频的播放路线)", example = ".play-lines a")
  private String lineSelector = "";

  @Schema(description = "剧集选择器(每一条线路下对应的剧集,一般是一个a标签)", example = ".episodes a")
  private String episodeSelector = "";

  @Schema(description = "剧集是否反转(如果是,则剧集列表是从后往前,否则是从前往后)", example = "false")
  private Boolean episodeReverse = false;

  @Schema(description = "播放页面Url(通常是网站的播放页面的视频播放地址)", example = "/play/{id}")
  private String playerUrl = "";

  @Schema(description = "播放页面请求方法(默认get)", example = "get")
  private String playerRequestMethod = "get";

  @Schema(description = "播放页面请求体(通常是网站的播放页面的请求体)")
  private Map<String, String> playerRequestBody = Map.of();

  @Schema(description = "播放页面请求头部(通常是网站的播放页面的请求头部)")
  private Map<String, String> playerRequestHeaders = Map.of("User-Agent", DEFAULT_USER_AGENT);

  @Schema(description = "是否是完整的播放Url(如果是 ,则不与 baseUrl 拼接,否则拼接)", example = "false")
  private Boolean fullPlayerUrl = false;

  @Schema(description = "播放视频选择器(通常是播放页面的视频标签,比如video,iframe等)", example = "video,iframe")
  private String playerVideoSelector = "";

  @Schema(description = "视频元素属性(通常是视频标签的src属性,比如video标签的src属性)", example = "src")
  private String videoElementAttribute = "";

  @Schema(description = "嵌入视频选择器,英文逗号分隔(通常是播放页面的嵌入视频标签,比如iframe等)", example = "iframe")
  private String embedVideoSelector = "";

  @Schema(description = "是否等待视频元素加载完成(如果是,则等待视频元素加载完成,否则立即返回)", example = "true")
  private Boolean waitForMediaElement = true;

  @Schema(description = "视频url截取,通常是从params参数中截取视频url,比如params=videoUrl=xxxx,则截取xxxx,如果是null,则直接返回匹配的url", example = "videoUrl=")
  private String videoUrlSubsChar="";

  @Schema(description = "规则更新时间")
  private LocalDateTime updateAt = LocalDateTime.now();

  @Schema(description = "规则是否启用", example = "true")
  private Boolean isEnabled = true;

  @Schema(description = "是否是本地规则", example = "true")
  private Boolean isLocal = true;
}
