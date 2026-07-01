# BetZone — Coding Interview Practice Environment

A pre-configured Android project used as a blank canvas for timed coding exercises. The `main` branch contains a clean, empty starter project with all infrastructure wired (Hilt, Room, Compose, Navigation) and a mock backend ready to go. Each practice attempt lives in its own branch.

## How it works

```
main (clean starter — never write exercise code here)
 ├── attempt/2026-07-01    ← your first practice run
 ├── attempt/2026-07-03    ← second attempt, fresh start
 ├── attempt/2026-07-05    ← and so on
 └── ...
```

**`main`** is the reset point. It contains:
- A runnable Android Studio project (Compose + Hilt + Room + Navigation)
- The mock backend (`MockApiInterceptor` for REST, `MockOddsSocket` for live odds)
- Retrofit, OkHttp, kotlinx.serialization, Biometric, and EncryptedSharedPreferences in the dependencies
- Stubbed Compose screens (login, events list, bet slip) with no business logic
- No ViewModel implementations, no repository implementations, no API service interfaces

You **never commit exercise code to `main`**. It stays clean so you can branch from it repeatedly.

## Running a practice session

### 1. Create a new branch

```bash
git checkout main
git pull
git checkout -b attempt/$(date +%Y-%m-%d)
```

### 2. Open in Android Studio

Let Gradle sync. Confirm the app builds and runs (you should see the stubbed UI with no data).

### 3. Start the timer

Set a **90-minute timer**. Open the exercise requirements PDF and begin implementing.

### 4. When finished

Commit your work to the attempt branch:

```bash
git add -A
git commit -m "attempt: 90-min practice run"
git push -u origin attempt/$(date +%Y-%m-%d)
```

### 5. Review and retry

Compare your attempt against the reference solution or a previous attempt. When ready for another run, go back to step 1 — `main` is untouched, so you get a fresh start every time.

## What's in `main`

```
app/
├── src/main/java/com/betzone/app/
│   ├── data/
│   │   ├── mock/
│   │   │   ├── MockApiInterceptor.kt      ← intercepts REST calls, returns canned JSON
│   │   │   └── MockOddsSocket.kt           ← simulates live odds ticking every 2–5s
│   │   └── model/
│   │       └── OddsUpdate.kt               ← data class used by the mock and your OddsRepository
│   ├── di/
│   │   └── AppModule.kt                    ← Hilt module (OkHttpClient with mock interceptor)
│   ├── ui/
│   │   ├── login/
│   │   │   └── LoginScreen.kt              ← stubbed Compose screen (no logic)
│   │   ├── events/
│   │   │   └── EventsScreen.kt             ← stubbed Compose screen (no logic)
│   │   └── betslip/
│   │       └── BetSlipScreen.kt            ← stubbed Compose screen (no logic)
│   └── BetZoneApp.kt                       ← Hilt application class
├── build.gradle.kts                         ← all dependencies already declared
└── ...
```

## Features to implement (per exercise)

Each practice session targets these features within 90 minutes:

| # | Feature | Key skills tested |
|---|---------|-------------------|
| 1 | Login + biometric unlock | EncryptedSharedPreferences, BiometricPrompt, StateFlow |
| 2 | Events list + pagination | Retrofit, DTO→domain mapping, append-on-scroll, UiState |
| 3 | Live odds via WebSocket | SharedFlow, per-selection StateFlow, version ordering |
| 4 | Bet slip + place bet | Room persistence, idempotency key, odds-change handling |
| 5 | Wallet balance | Server-authoritative cache, pre-check before placement |

Full requirements are in the exercise PDF. You're not expected to finish all five — quality and communication matter more than coverage.

## Tips

- **Don't modify `main`** with exercise code. If you accidentally commit to `main`, reset it: `git checkout main && git reset --hard origin/main`.
- **Name branches consistently** so you can compare attempts over time (`attempt/2026-07-01`, `attempt/2026-07-03-v2`, etc.).
- **Practise narrating aloud** while you code — the interview scores communication as heavily as the code itself.
- **Time-box each feature** (see the step-by-step guide) so you don't spend 60 minutes on login and never reach the bet slip.

## Tech stack

| Component | Library |
|-----------|---------|
| Language | Kotlin |
| UI | Jetpack Compose + Material3 |
| DI | Hilt |
| Networking | Retrofit + OkHttp + kotlinx.serialization |
| Database | Room |
| Async | Coroutines + Flow |
| Auth | BiometricPrompt + EncryptedSharedPreferences |
| Mock backend | OkHttp Interceptor (REST) + coroutine-based SharedFlow (WebSocket) |

---

Built from [android/architecture-templates](https://github.com/android/architecture-templates) (`base` branch).