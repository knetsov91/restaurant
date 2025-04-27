<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta http-equiv="x-ua-compatible" content="IE=edge"/>
<title>Test results - CreateEmployeeITest</title>
<link href="../css/base-style.css" rel="stylesheet" type="text/css"/>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<script src="../js/report.js" type="text/javascript"></script>
</head>
<body>
<div id="content">
<h1>CreateEmployeeITest</h1>
<div class="breadcrumbs">
<a href="../index.md">all</a> &gt;
<a href="../packages/restaurant.com.restaurant.html">restaurant.com.restaurant</a> &gt; CreateEmployeeITest</div>
<div id="summary">
<table>
<tr>
<td>
<div class="summaryGroup">
<table>
<tr>
<td>
<div class="infoBox" id="tests">
<div class="counter">1</div>
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
<div class="counter">1.488s</div>
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
<td class="success">createEmployee()</td>
<td class="success">1.488s</td>
<td class="success">passed</td>
</tr>
</table>
</div>
<div id="tab1" class="tab">
<h2>Standard output</h2>
<span class="code">
<pre>19:39:15.702 [Test worker] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [restaurant.com.restaurant.CreateEmployeeITest]: CreateEmployeeITest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
19:39:15.767 [Test worker] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration restaurant.com.restaurant.RestaurantApplication for test class restaurant.com.restaurant.CreateEmployeeITest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.3)

2025-04-27T19:39:16.158+03:00  INFO 411236 --- [    Test worker] r.com.restaurant.CreateEmployeeITest     : Starting CreateEmployeeITest using Java 17.0.11 with PID 411236 (started by kosio in /home/kosio/Documents/Projects/RestaurantApp/Restaurant/restaurant)
2025-04-27T19:39:16.159+03:00  INFO 411236 --- [    Test worker] r.com.restaurant.CreateEmployeeITest     : No active profile set, falling back to 1 default profile: &quot;default&quot;
2025-04-27T19:39:16.754+03:00  INFO 411236 --- [    Test worker] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-04-27T19:39:16.810+03:00  INFO 411236 --- [    Test worker] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 49 ms. Found 7 JPA repository interfaces.
2025-04-27T19:39:17.005+03:00  INFO 411236 --- [    Test worker] o.s.cloud.context.scope.GenericScope     : BeanFactory id=c849965e-9555-38a2-b5f9-b50cd5bb7aa0
2025-04-27T19:39:17.322+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2025-04-27T19:39:17.436+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection conn0: url=jdbc:h2:mem:testdb user=SA
2025-04-27T19:39:17.437+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2025-04-27T19:39:17.486+03:00  INFO 411236 --- [    Test worker] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-04-27T19:39:17.518+03:00  INFO 411236 --- [    Test worker] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.6.8.Final
2025-04-27T19:39:17.544+03:00  INFO 411236 --- [    Test worker] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2025-04-27T19:39:17.713+03:00  INFO 411236 --- [    Test worker] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-04-27T19:39:17.751+03:00  WARN 411236 --- [    Test worker] org.hibernate.dialect.Dialect            : HHH000511: The 2.3.232 version for [org.hibernate.dialect.PostgreSQLDialect] is no longer supported, hence certain features may not work properly. The minimum supported version is 12.0.0. Check the community dialects project for available legacy versions.
2025-04-27T19:39:17.754+03:00  WARN 411236 --- [    Test worker] org.hibernate.orm.deprecation            : HHH90000025: PostgreSQLDialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2025-04-27T19:39:17.768+03:00  INFO 411236 --- [    Test worker] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [Connecting through datasource 'HikariDataSource (HikariPool-1)']
	Database driver: undefined/unknown
	Database version: 2.3.232
	Autocommit mode: undefined/unknown
	Isolation level: undefined/unknown
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2025-04-27T19:39:18.537+03:00  INFO 411236 --- [    Test worker] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-04-27T19:39:18.548+03:00  WARN 411236 --- [    Test worker] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL &quot;set client_min_messages = WARNING&quot; via JDBC [Syntax error in SQL statement &quot;set [*]client_min_messages = WARNING&quot;; expected &quot;@, AUTOCOMMIT, EXCLUSIVE, IGNORECASE, PASSWORD, SALT, MODE, DATABASE, COLLATION, CLUSTER, DATABASE_EVENT_LISTENER, ALLOW_LITERALS, DEFAULT_TABLE_TYPE, SCHEMA, CATALOG, SCHEMA_SEARCH_PATH, JAVA_OBJECT_SERIALIZER, IGNORE_CATALOGS, SESSION, TRANSACTION, TIME, NON_KEYWORDS, DEFAULT_NULL_ORDERING&quot;;]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL &quot;set client_min_messages = WARNING&quot; via JDBC [Syntax error in SQL statement &quot;set [*]client_min_messages = WARNING&quot;; expected &quot;@, AUTOCOMMIT, EXCLUSIVE, IGNORECASE, PASSWORD, SALT, MODE, DATABASE, COLLATION, CLUSTER, DATABASE_EVENT_LISTENER, ALLOW_LITERALS, DEFAULT_TABLE_TYPE, SCHEMA, CATALOG, SCHEMA_SEARCH_PATH, JAVA_OBJECT_SERIALIZER, IGNORE_CATALOGS, SESSION, TRANSACTION, TIME, NON_KEYWORDS, DEFAULT_NULL_ORDERING&quot;;]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:213) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:186) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:156) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:116) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:238) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:144) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:141) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.internal.SessionFactoryImpl.&lt;init&gt;(SessionFactoryImpl.java:324) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:463) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1517) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:66) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:419) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:400) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1859) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1808) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:601) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:346) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:207) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:970) ~[spring-context-6.2.3.jar:6.2.3]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.3.jar:6.2.3]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:752) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader.lambda$loadContext$3(SpringBootContextLoader.java:137) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:58) ~[spring-core-6.2.3.jar:6.2.3]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:46) ~[spring-core-6.2.3.jar:6.2.3]
	at org.springframework.boot.SpringApplication.withHook(SpringApplication.java:1461) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader$ContextLoaderHook.run(SpringBootContextLoader.java:553) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:137) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:108) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:225) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:152) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:200) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:139) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:260) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:160) ~[spring-test-6.2.3.jar:6.2.3]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$11(ClassBasedTestDescriptor.java:378) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:383) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$12(ClassBasedTestDescriptor.java:378) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197) ~[na:na]
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150) ~[na:na]
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:377) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$instantiateAndPostProcessTestInstance$7(ClassBasedTestDescriptor.java:290) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:289) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$5(ClassBasedTestDescriptor.java:279) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at java.base/java.util.Optional.orElseGet(Optional.java:364) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$6(ClassBasedTestDescriptor.java:278) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:31) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$1(TestMethodTestDescriptor.java:105) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:104) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:68) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$2(NodeTestTask.java:128) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:128) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:160) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:146) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:144) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:143) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:100) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:160) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:146) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:144) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:143) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:100) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:198) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:169) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:93) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:58) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:141) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:57) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:103) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:85) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.DelegatingLauncher.execute(DelegatingLauncher.java:47) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:124) ~[na:na]
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$000(JUnitPlatformTestClassProcessor.java:99) ~[na:na]
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:94) ~[na:na]
	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:63) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36) ~[na:na]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24) ~[na:na]
	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33) ~[na:na]
	at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:92) ~[na:na]
	at jdk.proxy1/jdk.proxy1.$Proxy4.stop(Unknown Source) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker$3.run(TestWorker.java:200) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.executeAndMaintainThreadName(TestWorker.java:132) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:103) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:63) ~[na:na]
	at org.gradle.process.internal.worker.child.ActionExecutionWorker.execute(ActionExecutionWorker.java:56) ~[na:na]
	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:121) ~[na:na]
	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:71) ~[na:na]
	at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:69) ~[gradle-worker.jar:na]
	at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:74) ~[gradle-worker.jar:na]
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement &quot;set [*]client_min_messages = WARNING&quot;; expected &quot;@, AUTOCOMMIT, EXCLUSIVE, IGNORECASE, PASSWORD, SALT, MODE, DATABASE, COLLATION, CLUSTER, DATABASE_EVENT_LISTENER, ALLOW_LITERALS, DEFAULT_TABLE_TYPE, SCHEMA, CATALOG, SCHEMA_SEARCH_PATH, JAVA_OBJECT_SERIALIZER, IGNORE_CATALOGS, SESSION, TRANSACTION, TIME, NON_KEYWORDS, DEFAULT_NULL_ORDERING&quot;; SQL statement:
set client_min_messages = WARNING [42001-232]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:514) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:489) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.message.DbException.getSyntaxError(DbException.java:261) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.ParserBase.getSyntaxError(ParserBase.java:762) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parseSet(Parser.java:7592) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parsePrepared(Parser.java:614) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parse(Parser.java:581) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parse(Parser.java:561) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.prepareCommand(Parser.java:484) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.engine.SessionLocal.prepareLocal(SessionLocal.java:645) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.engine.SessionLocal.prepareCommand(SessionLocal.java:561) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1164) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.jdbc.JdbcStatement.executeInternal(JdbcStatement.java:245) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.jdbc.JdbcStatement.execute(JdbcStatement.java:231) ~[h2-2.3.232.jar:2.3.232]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.1.0.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	... 130 common frames omitted

2025-04-27T19:39:18.590+03:00  INFO 411236 --- [    Test worker] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2025-04-27T19:39:18.997+03:00  WARN 411236 --- [    Test worker] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2025-04-27T19:39:19.125+03:00  INFO 411236 --- [    Test worker] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with UserDetailsService bean with name userService
2025-04-27T19:39:19.227+03:00  INFO 411236 --- [    Test worker] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2025-04-27T19:39:19.719+03:00  INFO 411236 --- [    Test worker] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
2025-04-27T19:39:19.894+03:00  INFO 411236 --- [    Test worker] r.com.restaurant.CreateEmployeeITest     : Started CreateEmployeeITest in 3.971 seconds (process running for 4.693)
2025-04-27T19:39:19.907+03:00 ERROR 411236 --- [   scheduling-1] r.c.restaurant.scheduler.OrderScheduler  : Connection refused executing GET http://localhost:8081/api/v1/orders
2025-04-27T19:39:19.915+03:00  INFO 411236 --- [    Test worker] j.LocalContainerEntityManagerFactoryBean : Closing JPA EntityManagerFactory for persistence unit 'default'
2025-04-27T19:39:19.916+03:00 ERROR 411236 --- [    Test worker] .SchemaDropperImpl$DelayedDropActionImpl : HHH000478: Unsuccessful: set client_min_messages = WARNING
2025-04-27T19:39:19.922+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
2025-04-27T19:39:19.924+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.3)

2025-04-27T19:39:19.958+03:00  INFO 411236 --- [    Test worker] r.com.restaurant.CreateEmployeeITest     : Starting CreateEmployeeITest using Java 17.0.11 with PID 411236 (started by kosio in /home/kosio/Documents/Projects/RestaurantApp/Restaurant/restaurant)
2025-04-27T19:39:19.959+03:00  INFO 411236 --- [    Test worker] r.com.restaurant.CreateEmployeeITest     : No active profile set, falling back to 1 default profile: &quot;default&quot;
2025-04-27T19:39:20.108+03:00  INFO 411236 --- [    Test worker] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2025-04-27T19:39:20.117+03:00  INFO 411236 --- [    Test worker] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 8 ms. Found 7 JPA repository interfaces.
2025-04-27T19:39:20.147+03:00  INFO 411236 --- [    Test worker] o.s.cloud.context.scope.GenericScope     : BeanFactory id=c849965e-9555-38a2-b5f9-b50cd5bb7aa0
2025-04-27T19:39:20.185+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.HikariDataSource       : HikariPool-2 - Starting...
2025-04-27T19:39:20.191+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.pool.HikariPool        : HikariPool-2 - Added connection conn10: url=jdbc:h2:mem:testdb user=SA
2025-04-27T19:39:20.191+03:00  INFO 411236 --- [    Test worker] com.zaxxer.hikari.HikariDataSource       : HikariPool-2 - Start completed.
2025-04-27T19:39:20.197+03:00  INFO 411236 --- [    Test worker] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2025-04-27T19:39:20.199+03:00  INFO 411236 --- [    Test worker] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2025-04-27T19:39:20.205+03:00  INFO 411236 --- [    Test worker] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2025-04-27T19:39:20.206+03:00  WARN 411236 --- [    Test worker] org.hibernate.dialect.Dialect            : HHH000511: The 2.3.232 version for [org.hibernate.dialect.PostgreSQLDialect] is no longer supported, hence certain features may not work properly. The minimum supported version is 12.0.0. Check the community dialects project for available legacy versions.
2025-04-27T19:39:20.206+03:00  WARN 411236 --- [    Test worker] org.hibernate.orm.deprecation            : HHH90000025: PostgreSQLDialect does not need to be specified explicitly using 'hibernate.dialect' (remove the property setting and it will be selected by default)
2025-04-27T19:39:20.207+03:00  INFO 411236 --- [    Test worker] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
	Database JDBC URL [Connecting through datasource 'HikariDataSource (HikariPool-2)']
	Database driver: undefined/unknown
	Database version: 2.3.232
	Autocommit mode: undefined/unknown
	Isolation level: undefined/unknown
	Minimum pool size: undefined/unknown
	Maximum pool size: undefined/unknown
2025-04-27T19:39:20.313+03:00  INFO 411236 --- [    Test worker] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2025-04-27T19:39:20.314+03:00  WARN 411236 --- [    Test worker] o.h.t.s.i.ExceptionHandlerLoggedImpl     : GenerationTarget encountered exception accepting command : Error executing DDL &quot;set client_min_messages = WARNING&quot; via JDBC [Syntax error in SQL statement &quot;set [*]client_min_messages = WARNING&quot;; expected &quot;@, AUTOCOMMIT, EXCLUSIVE, IGNORECASE, PASSWORD, SALT, MODE, DATABASE, COLLATION, CLUSTER, DATABASE_EVENT_LISTENER, ALLOW_LITERALS, DEFAULT_TABLE_TYPE, SCHEMA, CATALOG, SCHEMA_SEARCH_PATH, JAVA_OBJECT_SERIALIZER, IGNORE_CATALOGS, SESSION, TRANSACTION, TIME, NON_KEYWORDS, DEFAULT_NULL_ORDERING&quot;;]

org.hibernate.tool.schema.spi.CommandAcceptanceException: Error executing DDL &quot;set client_min_messages = WARNING&quot; via JDBC [Syntax error in SQL statement &quot;set [*]client_min_messages = WARNING&quot;; expected &quot;@, AUTOCOMMIT, EXCLUSIVE, IGNORECASE, PASSWORD, SALT, MODE, DATABASE, COLLATION, CLUSTER, DATABASE_EVENT_LISTENER, ALLOW_LITERALS, DEFAULT_TABLE_TYPE, SCHEMA, CATALOG, SCHEMA_SEARCH_PATH, JAVA_OBJECT_SERIALIZER, IGNORE_CATALOGS, SESSION, TRANSACTION, TIME, NON_KEYWORDS, DEFAULT_NULL_ORDERING&quot;;]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:94) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.Helper.applySqlString(Helper.java:233) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.dropFromMetadata(SchemaDropperImpl.java:213) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.performDrop(SchemaDropperImpl.java:186) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:156) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.internal.SchemaDropperImpl.doDrop(SchemaDropperImpl.java:116) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.performDatabaseAction(SchemaManagementToolCoordinator.java:238) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.lambda$process$5(SchemaManagementToolCoordinator.java:144) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at java.base/java.util.HashMap.forEach(HashMap.java:1421) ~[na:na]
	at org.hibernate.tool.schema.spi.SchemaManagementToolCoordinator.process(SchemaManagementToolCoordinator.java:141) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.boot.internal.SessionFactoryObserverForSchemaExport.sessionFactoryCreated(SessionFactoryObserverForSchemaExport.java:37) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.internal.SessionFactoryObserverChain.sessionFactoryCreated(SessionFactoryObserverChain.java:35) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.internal.SessionFactoryImpl.&lt;init&gt;(SessionFactoryImpl.java:324) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.boot.internal.SessionFactoryBuilderImpl.build(SessionFactoryBuilderImpl.java:463) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1517) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:66) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:419) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:400) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1859) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1808) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:601) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:523) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:346) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:207) ~[spring-beans-6.2.3.jar:6.2.3]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:970) ~[spring-context-6.2.3.jar:6.2.3]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.3.jar:6.2.3]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:752) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader.lambda$loadContext$3(SpringBootContextLoader.java:137) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:58) ~[spring-core-6.2.3.jar:6.2.3]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:46) ~[spring-core-6.2.3.jar:6.2.3]
	at org.springframework.boot.SpringApplication.withHook(SpringApplication.java:1461) ~[spring-boot-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader$ContextLoaderHook.run(SpringBootContextLoader.java:553) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:137) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:108) ~[spring-boot-test-3.4.3.jar:3.4.3]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:225) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:152) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:130) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:155) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.beforeTestMethod(DependencyInjectionTestExecutionListener.java:135) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.TestContextManager.beforeTestMethod(TestContextManager.java:320) ~[spring-test-6.2.3.jar:6.2.3]
	at org.springframework.test.context.junit.jupiter.SpringExtension.beforeEach(SpringExtension.java:237) ~[spring-test-6.2.3.jar:6.2.3]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeBeforeEachCallbacks$3(TestMethodTestDescriptor.java:166) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeBeforeMethodsOrCallbacksUntilExceptionOccurs$7(TestMethodTestDescriptor.java:202) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeBeforeMethodsOrCallbacksUntilExceptionOccurs(TestMethodTestDescriptor.java:202) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeBeforeEachCallbacks(TestMethodTestDescriptor.java:165) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:132) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:68) ~[junit-jupiter-engine-5.11.4.jar:5.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:156) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:146) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:144) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:143) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:100) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:160) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:146) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:144) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:143) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:100) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:160) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:146) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:144) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:143) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:100) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54) ~[junit-platform-engine-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:198) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:169) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:93) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:58) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:141) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:57) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:103) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:85) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.junit.platform.launcher.core.DelegatingLauncher.execute(DelegatingLauncher.java:47) ~[junit-platform-launcher-1.11.4.jar:1.11.4]
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:124) ~[na:na]
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$000(JUnitPlatformTestClassProcessor.java:99) ~[na:na]
	at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:94) ~[na:na]
	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:63) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36) ~[na:na]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24) ~[na:na]
	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33) ~[na:na]
	at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:92) ~[na:na]
	at jdk.proxy1/jdk.proxy1.$Proxy4.stop(Unknown Source) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker$3.run(TestWorker.java:200) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.executeAndMaintainThreadName(TestWorker.java:132) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:103) ~[na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.execute(TestWorker.java:63) ~[na:na]
	at org.gradle.process.internal.worker.child.ActionExecutionWorker.execute(ActionExecutionWorker.java:56) ~[na:na]
	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:121) ~[na:na]
	at org.gradle.process.internal.worker.child.SystemApplicationClassLoaderWorker.call(SystemApplicationClassLoaderWorker.java:71) ~[na:na]
	at worker.org.gradle.process.internal.worker.GradleWorkerMain.run(GradleWorkerMain.java:69) ~[gradle-worker.jar:na]
	at worker.org.gradle.process.internal.worker.GradleWorkerMain.main(GradleWorkerMain.java:74) ~[gradle-worker.jar:na]
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Syntax error in SQL statement &quot;set [*]client_min_messages = WARNING&quot;; expected &quot;@, AUTOCOMMIT, EXCLUSIVE, IGNORECASE, PASSWORD, SALT, MODE, DATABASE, COLLATION, CLUSTER, DATABASE_EVENT_LISTENER, ALLOW_LITERALS, DEFAULT_TABLE_TYPE, SCHEMA, CATALOG, SCHEMA_SEARCH_PATH, JAVA_OBJECT_SERIALIZER, IGNORE_CATALOGS, SESSION, TRANSACTION, TIME, NON_KEYWORDS, DEFAULT_NULL_ORDERING&quot;; SQL statement:
set client_min_messages = WARNING [42001-232]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:514) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.message.DbException.getJdbcSQLException(DbException.java:489) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.message.DbException.getSyntaxError(DbException.java:261) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.ParserBase.getSyntaxError(ParserBase.java:762) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parseSet(Parser.java:7592) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parsePrepared(Parser.java:614) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parse(Parser.java:581) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.parse(Parser.java:561) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.command.Parser.prepareCommand(Parser.java:484) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.engine.SessionLocal.prepareLocal(SessionLocal.java:645) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.engine.SessionLocal.prepareCommand(SessionLocal.java:561) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1164) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.jdbc.JdbcStatement.executeInternal(JdbcStatement.java:245) ~[h2-2.3.232.jar:2.3.232]
	at org.h2.jdbc.JdbcStatement.execute(JdbcStatement.java:231) ~[h2-2.3.232.jar:2.3.232]
	at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94) ~[HikariCP-5.1.0.jar:na]
	at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java) ~[HikariCP-5.1.0.jar:na]
	at org.hibernate.tool.schema.internal.exec.GenerationTargetToDatabase.accept(GenerationTargetToDatabase.java:80) ~[hibernate-core-6.6.8.Final.jar:6.6.8.Final]
	... 115 common frames omitted

2025-04-27T19:39:20.332+03:00  INFO 411236 --- [    Test worker] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2025-04-27T19:39:20.425+03:00  WARN 411236 --- [    Test worker] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2025-04-27T19:39:20.460+03:00  INFO 411236 --- [    Test worker] r$InitializeUserDetailsManagerConfigurer : Global AuthenticationManager configured with UserDetailsService bean with name userService
2025-04-27T19:39:20.468+03:00  INFO 411236 --- [    Test worker] o.s.b.a.w.s.WelcomePageHandlerMapping    : Adding welcome page template: index
2025-04-27T19:39:20.632+03:00  INFO 411236 --- [    Test worker] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
2025-04-27T19:39:20.701+03:00  INFO 411236 --- [    Test worker] r.com.restaurant.CreateEmployeeITest     : Started CreateEmployeeITest in 0.775 seconds (process running for 5.5)
2025-04-27T19:39:20.701+03:00 ERROR 411236 --- [   scheduling-1] r.c.restaurant.scheduler.OrderScheduler  : Connection refused executing GET http://localhost:8081/api/v1/orders
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
