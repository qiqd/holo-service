package org.holo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.holo.entity.Rule;
import org.holo.service.RuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rule")
@RequiredArgsConstructor
@Tag(name = "规则", description = "规则管理接口")
public class RuleController {
  private final RuleService ruleService;

  @GetMapping
  @Operation(summary = "查询规则")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "查询成功",
                  content = @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Rule.class)))
  })
  public ResponseEntity<List<Rule>> queryRules() {
    List<Rule> rules = ruleService.queryAll();
    System.out.println(rules);
    return ResponseEntity.ok(rules);
  }

  @PostMapping
  @Operation(summary = "保存规则")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "保存成功",
                  content = @Content(mediaType = "application/json",
                          schema = @Schema(implementation = Rule.class)))
  })
  public ResponseEntity<Void> saveRules(@RequestBody List<Rule> rules) {
    ruleService.saveAll(rules);
    return ResponseEntity.ok().build();
  }
}
