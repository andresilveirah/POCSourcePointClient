Pod::Spec.new do |spec|
    spec.name                     = 'POCSourcepointClient'
    spec.version                  = '0.0.1'
    spec.homepage                 = 'https://github.com/andresilveirah/POCSourcepointclientKMM'
    spec.source                   = { :http=> ''}
    spec.authors                  = { 'Andre Herculano' => 'andresilveirah@gmail.com' }
    spec.license                  = ''
    spec.summary                  = 'A proof of concept client for sourcepoint APIs using Kotlin Multiplatform'
    spec.vendored_frameworks      = 'build/cocoapods/framework/POCSourcepointClient.framework'
    spec.libraries                = 'c++'
    spec.ios.deployment_target = '11.0'
                
                
    spec.pod_target_xcconfig = {
        'KOTLIN_PROJECT_PATH' => ':POCSourcepointClient',
        'PRODUCT_MODULE_NAME' => 'POCSourcepointClient',
    }
                
    spec.script_phases = [
        {
            :name => 'Build POCSourcepointClient',
            :execution_position => :before_compile,
            :shell_path => '/bin/sh',
            :script => <<-SCRIPT
                if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
                  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
                  exit 0
                fi
                set -ev
                REPO_ROOT="$PODS_TARGET_SRCROOT"
                "$REPO_ROOT/../gradlew" -p "$REPO_ROOT" $KOTLIN_PROJECT_PATH:syncFramework \
                    -Pkotlin.native.cocoapods.platform=$PLATFORM_NAME \
                    -Pkotlin.native.cocoapods.archs="$ARCHS" \
                    -Pkotlin.native.cocoapods.configuration="$CONFIGURATION"
            SCRIPT
        }
    ]
                
end