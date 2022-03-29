# opensearch-plugin-service-loader-example

Demonstrates the inability to rely on ServiceLoader or SPI based libraries inside of OpenSearch plugins.

This project starts from the project description here:
https://opensearch.org/blog/technical-posts/2021/06/my-first-steps-in-opensearch-plugins/#the-buildgradle-of-our-plugin

To set this example up, in a separate directory, run:
```
git clone https://github.com/opensearch-project/OpenSearch.git
cd OpenSearch
git checkout 1.2.4
./gradlew publishToMavenLocal -Dbuild.snapshot=false
```

# Expected behavior
```
./gradlew test

BUILD SUCCESSFUL
```

```
./gradlew check

BUILD SUCCESSFUL
```

# Actual Behavior
```
./gradlew test

BUILD SUCCESSFUL
```

```
./gradlew check
=======================================OpenSearch Build Hamster says Hello!
  Gradle Version        : 6.8.3
  OS Info               : Linux 4.14.268-205.500.amzn2.x86_64 (amd64)
  JDK Version           : 11 (Red Hat, Inc. JDK)
  JAVA_HOME             : /usr/lib/jvm/java-11-openjdk-11.0.13.0.8-1.amzn2.0.3.x86_64
  Random Testing Seed   : B1F5064971B5A52
  In FIPS 140 mode      : false
=======================================

> Task :yamlRestTest FAILED

=== Standard output of node `node{::yamlRestTest-0}` ===

»    ↓ errors and warnings from ~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/logs/opensearch.stdout.log ↓
» WARN ][o.o.g.DanglingIndicesState] [yamlRestTest-0] gateway.auto_import_dangling_indices is disabled, dangling indices will not be automatically detected or imported and must be managed manually
» ERROR][o.o.b.OpenSearchUncaughtExceptionHandler] [yamlRestTest-0] fatal error in thread [main], exiting
»  java.lang.ExceptionInInitializerError: null
»       at org.opensearch.rest.action.HelloWorldPlugin.getRestHandlers(HelloWorldPlugin.java:37) ~[?:?]
»       at org.opensearch.action.ActionModule.initRestHandlers(ActionModule.java:848) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.node.Node.<init>(Node.java:960) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.node.Node.<init>(Node.java:319) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.bootstrap.Bootstrap$5.<init>(Bootstrap.java:242) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.bootstrap.Bootstrap.setup(Bootstrap.java:242) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.bootstrap.Bootstrap.init(Bootstrap.java:412) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.bootstrap.OpenSearch.init(OpenSearch.java:178) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.bootstrap.OpenSearch.execute(OpenSearch.java:169) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.cli.EnvironmentAwareCommand.execute(EnvironmentAwareCommand.java:100) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.cli.Command.mainWithoutErrorHandling(Command.java:138) ~[opensearch-cli-1.2.4.jar:1.2.4]
»       at org.opensearch.cli.Command.main(Command.java:101) ~[opensearch-cli-1.2.4.jar:1.2.4]
»       at org.opensearch.bootstrap.OpenSearch.main(OpenSearch.java:135) ~[opensearch-1.2.4.jar:1.2.4]
»       at org.opensearch.bootstrap.OpenSearch.main(OpenSearch.java:101) ~[opensearch-1.2.4.jar:1.2.4]
»  Caused by: java.util.NoSuchElementException
»       at java.util.ServiceLoader$2.next(ServiceLoader.java:1309) ~[?:?]
»       at java.util.ServiceLoader$2.next(ServiceLoader.java:1297) ~[?:?]
»       at java.util.ServiceLoader$3.next(ServiceLoader.java:1395) ~[?:?]
»       at org.opensearch.rest.action.RestHelloWorldAction.<clinit>(RestHelloWorldAction.java:26) ~[?:?]
»       ... 14 more
»   ↓ last 40 non error or warning messages from ~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/logs/opensearch.stdout.log ↓
» [2022-03-18T20:51:56.633859Z] [BUILD] Configuring custom cluster specific distro directory: ~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/distro/1.2.4-INTEG_TEST
» [2022-03-18T20:51:56.714313Z] [BUILD] Copying additional config files from distro [~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/distro/1.2.4-INTEG_TEST/config/log4j2.properties, ~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/distro/1.2.4-INTEG_TEST/config/jvm.options, ~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/distro/1.2.4-INTEG_TEST/config/opensearch.yml, ~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/distro/1.2.4-INTEG_TEST/config/jvm.options.d]
» [2022-03-18T20:51:56.766244Z] [BUILD] installing 1 plugins in a single transaction
» [2022-03-18T20:51:59.971249Z] [BUILD] installed plugins
» [2022-03-18T20:51:59.996053Z] [BUILD] Creating opensearch keystore with password set to []
» [2022-03-18T20:52:01.671063Z] [BUILD] Installing 0modules
» [2022-03-18T20:52:01.682979Z] [BUILD] Starting OpenSearch process
» [2022-03-18T20:52:05,942][INFO ][o.o.n.Node               ] [yamlRestTest-0] version[1.2.4], pid[24169], build[zip/e505b10357c03ae8d26d675172402f2f2144ef0f/2022-01-14T03:38:06.881862Z], OS[Linux/4.14.268-205.500.amzn2.x86_64/amd64], JVM[Red Hat, Inc./OpenJDK 64-Bit Server VM/11.0.13/11.0.13+8-LTS]
» [2022-03-18T20:52:05,947][INFO ][o.o.n.Node               ] [yamlRestTest-0] JVM home [/usr/lib/jvm/java-11-openjdk-11.0.13.0.8-1.amzn2.0.3.x86_64]
» [2022-03-18T20:52:05,952][INFO ][o.o.n.Node               ] [yamlRestTest-0] JVM arguments [-Xshare:auto, -Dopensearch.networkaddress.cache.ttl=60, -Dopensearch.networkaddress.cache.negative.ttl=10, -XX:+AlwaysPreTouch, -Xss1m, -Djava.awt.headless=true, -Dfile.encoding=UTF-8, -Djna.nosys=true, -XX:-OmitStackTraceInFastThrow, -Dio.netty.noUnsafe=true, -Dio.netty.noKeySetOptimization=true, -Dio.netty.recycler.maxCapacityPerThread=0, -Dio.netty.allocator.numDirectArenas=0, -Dlog4j.shutdownHookEnabled=false, -Dlog4j2.disable.jmx=true, -Djava.locale.providers=SPI,COMPAT, -Xms1g, -Xmx1g, -XX:+UseConcMarkSweepGC, -XX:CMSInitiatingOccupancyFraction=75, -XX:+UseCMSInitiatingOccupancyOnly, -Djava.io.tmpdir=~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/tmp, -XX:+HeapDumpOnOutOfMemoryError, -XX:HeapDumpPath=logs, -XX:ErrorFile=logs/hs_err_pid%p.log, -Xlog:gc*,gc+age=trace,safepoint:file=logs/gc.log:utctime,pid,tags:filecount=32,filesize=64m, -Xms512m, -Xmx512m, -ea, -esa, -XX:MaxDirectMemorySize=268435456, -Dopensearch.path.home=~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/distro/1.2.4-INTEG_TEST, -Dopensearch.path.conf=~/opensearch-plugin-service-loader-example/build/testclusters/yamlRestTest-0/config, -Dopensearch.distribution.type=zip, -Dopensearch.bundled_jdk=false]
» [2022-03-18T20:52:06,353][INFO ][o.o.p.PluginsService     ] [yamlRestTest-0] loaded module [transport-netty4]
» [2022-03-18T20:52:06,354][INFO ][o.o.p.PluginsService     ] [yamlRestTest-0] loaded plugin [opensearch-rest-plugin]
» [2022-03-18T20:52:06,427][INFO ][o.o.e.NodeEnvironment    ] [yamlRestTest-0] using [1] data paths, mounts [[/ (/dev/nvme0n1p1)]], net usable_space [25.3gb], net total_space [79.9gb], types [xfs]
» [2022-03-18T20:52:06,429][INFO ][o.o.e.NodeEnvironment    ] [yamlRestTest-0] heap size [495.3mb], compressed ordinary object pointers [true]
» [2022-03-18T20:52:06,480][INFO ][o.o.n.Node               ] [yamlRestTest-0] node name [yamlRestTest-0], node ID [omfxzDaJS_m_-bUmHn9YUg], cluster name [yamlRestTest], roles [master, remote_cluster_client, data, ingest]
» [2022-03-18T20:52:08,358][INFO ][o.o.t.NettyAllocator     ] [yamlRestTest-0] creating NettyAllocator with the following configs: [name=unpooled, suggested_max_allocation_size=1mb, factors={opensearch.unsafe.use_unpooled_allocator=null, g1gc_enabled=false, g1gc_region_size=0b, heap_size=495.3mb}]
» [2022-03-18T20:52:08,484][INFO ][o.o.d.DiscoveryModule    ] [yamlRestTest-0] using discovery type [zen] and seed hosts providers [settings, file]
» [2022-03-18T20:52:09.748189Z] [BUILD] Stopping node

=== Standard error of node `node{::yamlRestTest-0}` ===

FAILURE: Build completed with 2 failures.

1: Task failed with an exception.
-----------
* What went wrong:
Execution failed for task ':yamlRestTest'.
> process was found dead while waiting for ports files, node{::yamlRestTest-0}

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.
==============================================================================

2: Task failed with an exception.
-----------
* What went wrong:
Reaper process died unexpectedly! Check the log at ~/opensearch-plugin-service-loader-example/.gradle/reaper/build-25134/reaper.log

* Try:
Run with --stacktrace option to get the stack trace. Run with --info or --debug option to get more log output. Run with --scan to get full insights.
==============================================================================

* Get more help at https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.8.3/userguide/command_line_interface.html#sec:command_line_warnings

BUILD FAILED in 23s
25 actionable tasks: 3 executed, 22 up-to-date
```

