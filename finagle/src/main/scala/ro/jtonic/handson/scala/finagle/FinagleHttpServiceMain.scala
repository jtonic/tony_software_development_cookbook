package ro.jtonic.handson.scala.finagle

import java.net.{InetSocketAddress, SocketAddress}

import com.twitter.finagle.builder.ServerBuilder
import com.twitter.finagle.{ListeningServer, Service}
import com.twitter.util.{Await, Future}
import io.netty.handler.codec.http.{DefaultHttpResponse, HttpRequest, HttpResponse, HttpResponseStatus, HttpVersion}

object FinagleHttpServiceMain extends App {

  val service: Service[HttpRequest, HttpResponse] = (request: HttpRequest) => {
    val res = request.uri() match {
      case "/" => new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK)
      case _ => new DefaultHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND)
    }
    Future.value(res)
  }

  val address: SocketAddress = new InetSocketAddress(8080)
  val server: ListeningServer = ServerBuilder()
                                  .bindTo(address)
      .name("HttpServer")
      .build(service)
  Await.ready(server)
}
