<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="x-ua-compatible" content="IE=edge"/>
<title>Test results - RestaurantControllerApiTest</title>
<link href="../css/base-style.css" rel="stylesheet" type="text/css"/>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<script src="../js/report.js" type="text/javascript"></script>
</head>
<body>
<div id="content">
<h1>RestaurantControllerApiTest</h1>
<div class="breadcrumbs">
<a href="../index.md">all</a> &gt;
<a href="../packages/restaurant.com.restaurant.web.md">restaurant.com.restaurant.web</a> &gt; RestaurantControllerApiTest</div>
<div id="summary">
<table>
<tr>
<td>
<div class="summaryGroup">
<table>
<tr>
<td>
<div class="infoBox" id="tests">
<div class="counter">4</div>
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
<div class="counter">0.044s</div>
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
<td class="success">getAuthenticatedRequestToCreateRestaurantEndpoint_shouldRenderRestaurantCreateView()</td>
<td class="success">0.011s</td>
<td class="success">passed</td>
</tr>
<tr>
<td class="success">getAuthenticatedRequestToRestaurantEmployeesEndpoint_shouldRenderRestaurantEmployeesView()</td>
<td class="success">0.008s</td>
<td class="success">passed</td>
</tr>
<tr>
<td class="success">getAuthenticatedRequestToRestaurantMenusEndpoint_shouldRenderMenusView()</td>
<td class="success">0.018s</td>
<td class="success">passed</td>
</tr>
<tr>
<td class="success">getAuthenticatedRequestToRestaurantsIndexEndpoint_renderRestaurantsView()</td>
<td class="success">0.007s</td>
<td class="success">passed</td>
</tr>
</table>
</div>
<div id="tab1" class="tab">
<h2>Standard output</h2>
<span class="code">
<pre>2025-04-27T19:39:25.688+03:00  INFO 411236 --- [    Test worker] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [restaurant.com.restaurant.web.RestaurantControllerApiTest]: RestaurantControllerApiTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2025-04-27T19:39:25.691+03:00  INFO 411236 --- [    Test worker] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration restaurant.com.restaurant.RestaurantApplication for test class restaurant.com.restaurant.web.RestaurantControllerApiTest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.3)

2025-04-27T19:39:25.720+03:00  INFO 411236 --- [    Test worker] r.c.r.web.RestaurantControllerApiTest    : Starting RestaurantControllerApiTest using Java 17.0.11 with PID 411236 (started by kosio in /home/kosio/Documents/Projects/RestaurantApp/Restaurant/restaurant)
2025-04-27T19:39:25.720+03:00  INFO 411236 --- [    Test worker] r.c.r.web.RestaurantControllerApiTest    : No active profile set, falling back to 1 default profile: &quot;default&quot;
2025-04-27T19:39:25.835+03:00  WARN 411236 --- [    Test worker] .s.s.UserDetailsServiceAutoConfiguration : 

Using generated security password: 8053dc77-cd1d-4b10-9fc8-866aed7d42da

This generated password is for development use only. Your security configuration must be updated before running your application in production.

2025-04-27T19:39:25.836+03:00  INFO 411236 --- [    Test worker] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with UserDetailsService bean with name inMemoryUserDetailsManager
2025-04-27T19:39:25.842+03:00  INFO 411236 --- [    Test worker] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2025-04-27T19:39:25.934+03:00  INFO 411236 --- [    Test worker] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2025-04-27T19:39:25.934+03:00  INFO 411236 --- [    Test worker] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2025-04-27T19:39:25.934+03:00  INFO 411236 --- [    Test worker] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 0 ms
2025-04-27T19:39:25.939+03:00  INFO 411236 --- [    Test worker] r.c.r.web.RestaurantControllerApiTest    : Started RestaurantControllerApiTest in 0.246 seconds (process running for 10.739)
2025-04-27T19:39:25.954+03:00  WARN 411236 --- [    Test worker] actStandardFragmentInsertionTagProcessor : [THYMELEAF][Test worker][restaurant/restaurant-menus] Deprecated unwrapped fragment expression &quot;fragments/navbar :: navbar&quot; found in template restaurant/restaurant-menus, line 12, col 15. Please use the complete syntax of fragment expressions instead (&quot;~{fragments/navbar :: navbar}&quot;). The old, unwrapped syntax for fragment expressions will be removed in future versions of Thymeleaf.
2025-04-27T19:39:25.963+03:00  WARN 411236 --- [    Test worker] actStandardFragmentInsertionTagProcessor : [THYMELEAF][Test worker][restaurant/restaurant-employees] Deprecated unwrapped fragment expression &quot;fragments/navbar :: navbar&quot; found in template restaurant/restaurant-employees, line 12, col 15. Please use the complete syntax of fragment expressions instead (&quot;~{fragments/navbar :: navbar}&quot;). The old, unwrapped syntax for fragment expressions will be removed in future versions of Thymeleaf.
2025-04-27T19:39:25.971+03:00  WARN 411236 --- [    Test worker] actStandardFragmentInsertionTagProcessor : [THYMELEAF][Test worker][restaurant/restaurants] Deprecated unwrapped fragment expression &quot;fragments/navbar :: navbar&quot; found in template restaurant/restaurants, line 12, col 15. Please use the complete syntax of fragment expressions instead (&quot;~{fragments/navbar :: navbar}&quot;). The old, unwrapped syntax for fragment expressions will be removed in future versions of Thymeleaf.
2025-04-27T19:39:25.979+03:00  WARN 411236 --- [    Test worker] actStandardFragmentInsertionTagProcessor : [THYMELEAF][Test worker][restaurant/restaurant-create] Deprecated unwrapped fragment expression &quot;fragments/navbar :: navbar&quot; found in template restaurant/restaurant-create, line 12, col 15. Please use the complete syntax of fragment expressions instead (&quot;~{fragments/navbar :: navbar}&quot;). The old, unwrapped syntax for fragment expressions will be removed in future versions of Thymeleaf.
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
