package com.betzone.app.data.mock

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okio.Buffer
import org.json.JSONObject

class MockApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath
        Thread.sleep((300L..800L).random()) // latency
        
        return when {
            path == "/auth/login" -> mockLogin(request)
            path.startsWith("/events") -> mockEvents(request)
            path == "/bets" -> mockPlaceBet(request)
            path == "/wallet/balance" -> mockBalance(request)
            else -> chain.proceed(request)
        }
    }

    private fun mockLogin(request: Request): Response {
        val bodyText = request.body?.let { body ->
            val buffer = Buffer()
            body.writeTo(buffer)
            buffer.readUtf8()
        } ?: ""

        // Parse JSON safely
        val (username, password) = try {
            val obj = JSONObject(bodyText)
            obj.optString("username") to obj.optString("password")
        } catch (e: Exception) {
            // Bad request -> return 400
            val respBody = JSONObject().put("error", "invalid_json").put("message", "Malformed JSON").toString()
            return Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .code(400)
                .message("Bad Request")
                .body(respBody.toResponseBody("application/json".toMediaTypeOrNull()))
                .build()
        }

        return if (username == "demo" && password == "pass") {
            Response.Builder()
                .code(200)
                .message("Mock response")
                .request(request)
                .protocol(Protocol.HTTP_1_0)
                .body(LoginResponse.succesfulResponse.toResponseBody("application/json".toMediaTypeOrNull()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            Response.Builder()
                .code(401)
                .message("Mock response")
                .request(request)
                .protocol(Protocol.HTTP_1_0)
                .body(LoginResponse.errorResponse.toResponseBody("application/json".toMediaTypeOrNull()))
                .addHeader("content-type", "application/json")
                .build()
        }
    }

    private fun mockEvents(request: Request): Response {
        return Response.Builder()
            .code(200)
            .message("Mock response")
            .request(request)
            .protocol(Protocol.HTTP_1_0)
            .body(EventResponse.succesfulResponse.toResponseBody("application/json".toMediaTypeOrNull()))
            .addHeader("content-type", "application/json")
            .build()
    }

    private fun mockPlaceBet(request: Request): Response {
        val random = (1..10).random()
        return if (random % 5 == 0) {
            Response.Builder()
                .code(401)
                .message("Mock response")
                .request(request)
                .protocol(Protocol.HTTP_1_0)
                .body(LoginResponse.errorResponse.toResponseBody("application/json".toMediaTypeOrNull()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            Response.Builder()
                .code(200)
                .message("Mock response")
                .request(request)
                .protocol(Protocol.HTTP_1_0)
                .body(LoginResponse.succesfulResponse.toResponseBody("application/json".toMediaTypeOrNull()))
                .addHeader("content-type", "application/json")
                .build()
        }
    }

    private fun mockBalance(request: Request): Response {
        return Response.Builder()
            .code(200)
            .message("Mock response")
            .request(request)
            .protocol(Protocol.HTTP_1_0)
            .body(WalletResponse.succesfulResponse.toResponseBody("application/json".toMediaTypeOrNull()))
            .addHeader("content-type", "application/json")
            .build()

    }

}