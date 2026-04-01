package org.holo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.holo.content.UserContent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("/callback")
@Tag(name = "认证回调接口", description = "处理认证回调相关的接口")
@RequiredArgsConstructor
public class AuthCallbackController {
  private final UserContent userContent;
  private final Map<String, String> userId2CodeMap = new HashMap<>();

  @GetMapping
  public ResponseEntity<String> callback(@RequestParam("code") String code) {
    userId2CodeMap.put(userContent.getUserId(), code);
    return ResponseEntity.ok("""
            <div style="display:flex;justify-content:center;align-items:center;height:100vh;font-size:18px;color:#333;">
              认证成功，可以关闭窗口
            </div>
            """);
  }


}
