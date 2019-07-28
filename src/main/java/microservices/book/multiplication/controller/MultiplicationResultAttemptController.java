package microservices.book.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {
  private final MultiplicationService multiplicationService;

  @Autowired
  MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
    this.multiplicationService = multiplicationService;
  }

  @GetMapping
  ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(
      @RequestParam("alias") String alias) {
    return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
  }

  @PostMapping
  ResponseEntity<ResultResponse> postResult(
      @RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
    return ResponseEntity.ok(
        new ResultResponse(multiplicationService.checkAttempt(multiplicationResultAttempt)));
  }

  @RequiredArgsConstructor
  @NoArgsConstructor(force = true)
  @Getter
  public static final class ResultResponse {
    private final boolean correct;
  }
}
