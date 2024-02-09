@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  connector-prod startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and CONNECTOR_PROD_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\connector-prod-1.0.0-basecamp.jar;%APP_HOME%\lib\multipart-1.0.0-basecamp.jar;%APP_HOME%\lib\control-plane-core-1.0.3-basecamp.jar;%APP_HOME%\lib\boot-1.0.3-basecamp.jar;%APP_HOME%\lib\connector-core-1.0.3-basecamp.jar;%APP_HOME%\lib\core-1.0.0-basecamp.jar;%APP_HOME%\lib\ids-1.0.3-basecamp.jar;%APP_HOME%\lib\ids-api-multipart-endpoint-v1-1.0.3-basecamp.jar;%APP_HOME%\lib\http-1.0.3-basecamp.jar;%APP_HOME%\lib\jersey-core-1.0.3-basecamp.jar;%APP_HOME%\lib\api-observability-1.0.3-basecamp.jar;%APP_HOME%\lib\oauth2-core-1.0.3-basecamp.jar;%APP_HOME%\lib\vault-filesystem-1.0.3-basecamp.jar;%APP_HOME%\lib\oauth2-client-1.0.3-basecamp.jar;%APP_HOME%\lib\ids-api-multipart-dispatcher-v1-1.0.3-basecamp.jar;%APP_HOME%\lib\http-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\policy-engine-1.0.3-basecamp.jar;%APP_HOME%\lib\contract-core-1.0.3-basecamp.jar;%APP_HOME%\lib\control-plane-aggregate-services-1.0.3-basecamp.jar;%APP_HOME%\lib\ids-transform-v1-1.0.3-basecamp.jar;%APP_HOME%\lib\ids-core-1.0.3-basecamp.jar;%APP_HOME%\lib\ids-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\control-plane-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\catalog-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\contract-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\transfer-core-1.0.3-basecamp.jar;%APP_HOME%\lib\transfer-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\policy-engine-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\transaction-datasource-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\jetty-core-1.0.3-basecamp.jar;%APP_HOME%\lib\ids-api-configuration-1.0.3-basecamp.jar;%APP_HOME%\lib\management-api-configuration-1.0.3-basecamp.jar;%APP_HOME%\lib\api-core-1.0.3-basecamp.jar;%APP_HOME%\lib\auth-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\web-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\aggregate-service-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\state-machine-1.0.3-basecamp.jar;%APP_HOME%\lib\policy-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\transform-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\transfer-data-plane-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\jwt-core-1.0.3-basecamp.jar;%APP_HOME%\lib\oauth2-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\jwt-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\core-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\ids-jsonld-serdes-1.0.3-basecamp.jar;%APP_HOME%\lib\util-1.0.3-basecamp.jar;%APP_HOME%\lib\transaction-spi-1.0.3-basecamp.jar;%APP_HOME%\lib\policy-evaluator-1.0.3-basecamp.jar;%APP_HOME%\lib\policy-model-1.0.3-basecamp.jar;%APP_HOME%\lib\runtime-metamodel-1.0.3-basecamp.jar;%APP_HOME%\lib\okhttp-dnsoverhttps-4.10.0.jar;%APP_HOME%\lib\failsafe-okhttp-3.2.4.jar;%APP_HOME%\lib\okhttp-4.10.0.jar;%APP_HOME%\lib\okio-jvm-3.0.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.6.10.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.6.10.jar;%APP_HOME%\lib\kotlin-stdlib-1.6.20.jar;%APP_HOME%\lib\annotations-15.0.jar;%APP_HOME%\lib\infomodel-java-1.0.4-basecamp.jar;%APP_HOME%\lib\jersey-media-json-jackson-3.0.8.jar;%APP_HOME%\lib\infomodel-util-1.0.4-basecamp.jar;%APP_HOME%\lib\swagger-jaxrs2-jakarta-2.2.2.jar;%APP_HOME%\lib\jackson-jakarta-rs-json-provider-2.14.0-rc2.jar;%APP_HOME%\lib\jackson-module-jakarta-xmlbind-annotations-2.14.0-rc2.jar;%APP_HOME%\lib\swagger-integration-jakarta-2.2.2.jar;%APP_HOME%\lib\swagger-core-jakarta-2.2.2.jar;%APP_HOME%\lib\swagger-models-jakarta-2.2.2.jar;%APP_HOME%\lib\java-1.0.1-basecamp.jar;%APP_HOME%\lib\util-1.0.1-basecamp.jar;%APP_HOME%\lib\jackson-annotations-2.14.0-rc2.jar;%APP_HOME%\lib\jackson-jakarta-rs-base-2.14.0-rc2.jar;%APP_HOME%\lib\jackson-dataformat-yaml-2.14.0-rc2.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.14.0-rc2.jar;%APP_HOME%\lib\java-jwt-4.2.2.jar;%APP_HOME%\lib\jackson-databind-2.14.0-rc2.jar;%APP_HOME%\lib\jackson-core-2.14.0-rc2.jar;%APP_HOME%\lib\jersey-container-servlet-3.0.8.jar;%APP_HOME%\lib\jersey-container-servlet-core-3.0.8.jar;%APP_HOME%\lib\jersey-bean-validation-3.0.8.jar;%APP_HOME%\lib\jersey-server-3.0.8.jar;%APP_HOME%\lib\jersey-media-multipart-3.0.8.jar;%APP_HOME%\lib\jersey-hk2-3.0.8.jar;%APP_HOME%\lib\jersey-client-3.0.8.jar;%APP_HOME%\lib\jersey-common-3.0.8.jar;%APP_HOME%\lib\jersey-entity-filtering-3.0.8.jar;%APP_HOME%\lib\jakarta.ws.rs-api-3.1.0.jar;%APP_HOME%\lib\opentelemetry-extension-annotations-1.12.0.jar;%APP_HOME%\lib\opentelemetry-api-1.12.0.jar;%APP_HOME%\lib\websocket-jakarta-server-11.0.12.jar;%APP_HOME%\lib\websocket-servlet-11.0.12.jar;%APP_HOME%\lib\jetty-annotations-11.0.12.jar;%APP_HOME%\lib\websocket-jakarta-client-11.0.12.jar;%APP_HOME%\lib\websocket-jakarta-common-11.0.12.jar;%APP_HOME%\lib\websocket-core-client-11.0.12.jar;%APP_HOME%\lib\jetty-client-11.0.12.jar;%APP_HOME%\lib\jetty-plus-11.0.12.jar;%APP_HOME%\lib\jetty-webapp-11.0.12.jar;%APP_HOME%\lib\jetty-servlet-11.0.12.jar;%APP_HOME%\lib\websocket-core-server-11.0.12.jar;%APP_HOME%\lib\websocket-core-common-11.0.12.jar;%APP_HOME%\lib\jetty-security-11.0.12.jar;%APP_HOME%\lib\jetty-server-11.0.12.jar;%APP_HOME%\lib\jetty-http-11.0.12.jar;%APP_HOME%\lib\jetty-alpn-client-11.0.12.jar;%APP_HOME%\lib\jetty-io-11.0.12.jar;%APP_HOME%\lib\jetty-jndi-11.0.12.jar;%APP_HOME%\lib\jetty-xml-11.0.12.jar;%APP_HOME%\lib\jetty-util-11.0.12.jar;%APP_HOME%\lib\slf4j-api-2.0.0.jar;%APP_HOME%\lib\bcpkix-jdk18on-1.72.jar;%APP_HOME%\lib\jetty-jakarta-servlet-api-5.0.2.jar;%APP_HOME%\lib\nimbus-jose-jwt-9.25.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\mimepull-1.9.13.jar;%APP_HOME%\lib\opentelemetry-context-1.12.0.jar;%APP_HOME%\lib\bcutil-jdk18on-1.72.jar;%APP_HOME%\lib\bcprov-jdk18on-1.72.jar;%APP_HOME%\lib\jakarta.annotation-api-2.1.1.jar;%APP_HOME%\lib\jakarta.inject-api-2.0.1.jar;%APP_HOME%\lib\jakarta.validation-api-3.0.2.jar;%APP_HOME%\lib\osgi-resource-locator-1.0.3.jar;%APP_HOME%\lib\jakarta.xml.bind-api-3.0.1.jar;%APP_HOME%\lib\hk2-locator-3.0.3.jar;%APP_HOME%\lib\javassist-3.28.0-GA.jar;%APP_HOME%\lib\classgraph-4.8.138.jar;%APP_HOME%\lib\swagger-annotations-jakarta-2.2.2.jar;%APP_HOME%\lib\jcip-annotations-1.0-1.jar;%APP_HOME%\lib\failsafe-3.2.4.jar;%APP_HOME%\lib\jakarta.activation-2.0.1.jar;%APP_HOME%\lib\hk2-api-3.0.3.jar;%APP_HOME%\lib\aopalliance-repackaged-3.0.3.jar;%APP_HOME%\lib\hk2-utils-3.0.3.jar;%APP_HOME%\lib\jetty-jakarta-websocket-api-2.0.0.jar;%APP_HOME%\lib\hibernate-validator-7.0.1.Final.jar;%APP_HOME%\lib\jakarta.el-4.0.2.jar;%APP_HOME%\lib\jakarta.el-api-4.0.0.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.6.20.jar;%APP_HOME%\lib\asm-commons-9.3.jar;%APP_HOME%\lib\asm-analysis-9.3.jar;%APP_HOME%\lib\asm-tree-9.3.jar;%APP_HOME%\lib\asm-9.3.jar;%APP_HOME%\lib\commons-lang3-3.12.0.jar;%APP_HOME%\lib\jboss-logging-3.4.1.Final.jar;%APP_HOME%\lib\classmate-1.5.1.jar;%APP_HOME%\lib\jakarta.transaction-api-2.0.0.jar;%APP_HOME%\lib\snakeyaml-1.33.jar


@rem Execute connector-prod
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %CONNECTOR_PROD_OPTS%  -classpath "%CLASSPATH%" org.eclipse.edc.boot.system.runtime.BaseRuntime %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable CONNECTOR_PROD_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%CONNECTOR_PROD_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
