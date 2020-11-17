#### 浏览器存储介质localStorage、cookie、sessionStorage
浏览器存储介质其实本质上也可以称之为缓存，比如Cookie， 就是早期我们使用最多的，目前用户的id以及token也是保存在cookie中的。

通过保存数据后，那么可以获得并且和后端服务器交互。

Cookie是保存在浏览器的，如果不设置过期时间，那么cookie会保存到内存，如果浏览器关了，那么cookie就没了，这也起到了会话的作用。如果我们设置了过期时间，那么cookie会保存在硬盘，关闭浏览器cookie还会存在，直到过期，一般7天重 新登录或者1个月免登录都是这样的。

cookie中只能存一些 字符串类的内容，对象或list以json字符串去保存，但是需要注意，cookie有大小限制，4k左右，所以一般不会设置很大的数据放到cookie中。

在HTML5以后，那么浏览器可以使用webStorage，其实也是类似一种数据存储的表现形式，是对cookie的一种改良。

1. sessionStorage:数据可以保存到session对象中。session是指用户在浏览某个网站时，从进入网站到浏览器关闭的这一段段时间 ，称之为会话。session中 可以保存任何数据。

2. localStorage:数据可以保存在客户端本地磁盘中，就算浏览器关了，数据还是会存在的，重启电脑，下次打开网站，数据还是能获取。这相当于数据持久化的一种表现。



sessionStorage和localStorage的区别就是：

sessionStorage是 临时保存，localStorage是 永久保存持久化。

他们的数据存储在5M左右，比cookie大很多。安全方面也比cookie好，因为不会被携带到请求中，通过webStroage，大多网站数据进行缓存后，可以更快加载，也能为并发减轻一定压力。