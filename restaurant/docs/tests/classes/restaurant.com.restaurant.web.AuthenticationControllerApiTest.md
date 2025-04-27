<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="x-ua-compatible" content="IE=edge"/>
<title>Test results - AuthenticationControllerApiTest</title>
<link href="../css/base-style.css" rel="stylesheet" type="text/css"/>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<script src="../js/report.js" type="text/javascript"></script>
</head>
<body>
<div id="content">
<h1>AuthenticationControllerApiTest</h1>
<div class="breadcrumbs">
<a href="../index.md">all</a> &gt;
<a href="../packages/restaurant.com.restaurant.web.html">restaurant.com.restaurant.web</a> &gt; AuthenticationControllerApiTest</div>
<div id="summary">
<table>
<tr>
<td>
<div class="summaryGroup">
<table>
<tr>
<td>
<div class="infoBox" id="tests">
<div class="counter">3</div>
<p>tests</p>
</div>
</td>
<td>
<div class="infoBox" id="failures">
<div class="counter">0</div>
<p>failures</p>
</div>
</td>
<td>
<div class="infoBox" id="ignored">
<div class="counter">0</div>
<p>ignored</p>
</div>
</td>
<td>
<div class="infoBox" id="duration">
<div class="counter">0.777s</div>
<p>duration</p>
</div>
</td>
</tr>
</table>
</div>
</td>
<td>
<div class="infoBox success" id="successRate">
<div class="percent">100%</div>
<p>successful</p>
</div>
</td>
</tr>
</table>
</div>
<div id="tabs">
<ul class="tabLinks">
<li>
<a href="#tab0">Tests</a>
</li>
<li>
<a href="#tab1">Standard output</a>
</li>
</ul>
<div id="tab0" class="tab">
<h2>Tests</h2>
<table>
<thead>
<tr>
<th>Test</th>
<th>Duration</th>
<th>Result</th>
</tr>
</thead>
<tr>
<td class="success">getRequestToLoginEndpoint_shouldRenderLoginView()</td>
<td class="success">0.691s</td>
<td class="success">passed</td>
</tr>
<tr>
<td class="success">getRequestToRegisterEndpoint_shouldReturnRegisterView()</td>
<td class="success">0.015s</td>
<td class="success">passed</td>
</tr>
<tr>
<td class="success">testRegistration_whenUserExists_thenThrowsException()</td>
<td class="success">0.071s</td>
<td class="success">passed</td>
</tr>
</table>
</div>
<div id="tab1" class="tab">
<h2>Standard output</h2>
<span class="code">
<pre>2025-04-27T19:39:21.945+03:00  INFO 411236 --- [    Test worker] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [restaurant.com.restaurant.web.AuthenticationControllerApiTest]: AuthenticationControllerApiTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2025-04-27T19:39:21.991+03:00  INFO 411236 --- [    Test worker] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration restaurant.com.restaurant.RestaurantApplication for test class restaurant.com.restaurant.web.AuthenticationControllerApiTest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.3)

2025-04-27T19:39:22.057+03:00  INFO 411236 --- [    Test worker] r.c.r.w.AuthenticationControllerApiTest  : Starting AuthenticationControllerApiTest using Java 17.0.11 with PID 411236 (started by kosio in /home/kosio/Documents/Projects/RestaurantApp/Restaurant/restaurant)
2025-04-27T19:39:22.057+03:00  INFO 411236 --- [    Test worker] r.c.r.w.AuthenticationControllerApiTest  : No active profile set, falling back to 1 default profile: &quot;default&quot;
2025-04-27T19:39:22.305+03:00  WARN 411236 --- [    Test worker] r$InitializeUserDetailsManagerConfigurer : Found 2 UserDetailsService beans, with names [inMemoryUserDetailsManager, restaurant.com.restaurant.user.service.UserService#0]. Global Authentication Manager will not use a UserDetailsService for username/password login. Consider publishing a single UserDetailsService bean.
2025-04-27T19:39:22.322+03:00  INFO 411236 --- [    Test worker] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2025-04-27T19:39:22.558+03:00  WARN 411236 --- [    Test worker] .s.s.UserDetailsServiceAutoConfiguration : 

Using generated security password: ca19d9b1-1374-4cc1-b02f-d133f3f84fef

This generated password is for development use only. Your security configuration must be updated before running your application in production.

2025-04-27T19:39:22.598+03:00  INFO 411236 --- [    Test worker] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2025-04-27T19:39:22.599+03:00  INFO 411236 --- [    Test worker] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2025-04-27T19:39:22.600+03:00  INFO 411236 --- [    Test worker] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 1 ms
2025-04-27T19:39:22.618+03:00  INFO 411236 --- [    Test worker] r.c.r.w.AuthenticationControllerApiTest  : Started AuthenticationControllerApiTest in 0.623 seconds (process running for 7.417)
2025-04-27T19:39:23.208+03:00  WARN 411236 --- [    Test worker] actStandardFragmentInsertionTagProcessor : [THYMELEAF][Test worker][login] Deprecated unwrapped fragment expression &quot;fragments/navbar :: navbar&quot; found in template login, line 12, col 15. Please use the complete syntax of fragment expressions instead (&quot;~{fragments/navbar :: navbar}&quot;). The old, unwrapped syntax for fragment expressions will be removed in future versions of Thymeleaf.
2025-04-27T19:39:23.391+03:00  WARN 411236 --- [    Test worker] actStandardFragmentInsertionTagProcessor : [THYMELEAF][Test worker][register] Deprecated unwrapped fragment expression &quot;fragments/navbar :: navbar&quot; found in template register, line 12, col 11. Please use the complete syntax of fragment expressions instead (&quot;~{fragments/navbar :: navbar}&quot;). The old, unwrapped syntax for fragment expressions will be removed in future versions of Thymeleaf.
</pre>
</span>
</div>
</div>
<div id="footer">
<p>
<div>
<label class="hidden" id="label-for-line-wrapping-toggle" for="line-wrapping-toggle">Wrap lines
<input id="line-wrapping-toggle" type="checkbox" autocomplete="off"/>
</label>
</div>Generated by 
<a href="http://www.gradle.org">Gradle 8.12.1</a> at Apr 27, 2025, 7:39:26 PM</p>
</div>
</div>
</body>
</html>
