package com.graphaware.runtime.bootstrap;

import com.graphaware.runtime.GraphAwareRuntime;
import com.graphaware.runtime.GraphAwareRuntimeModuleBootstrapper;
import org.neo4j.graphdb.config.Setting;

import java.util.Map;

import static org.neo4j.helpers.Settings.STRING;
import static org.neo4j.helpers.Settings.setting;

/**
 * {@link com.graphaware.runtime.GraphAwareRuntimeModuleBootstrapper} for {@link TestRuntimeModule}.
 */
public class TestModuleBootstrapper implements GraphAwareRuntimeModuleBootstrapper {

    public static final Setting<String> MODULE_ENABLED = setting("com.graphaware.module.test.1", STRING, TestModuleBootstrapper.class.getCanonicalName());
    public static final Setting<String> MODULE_CONFIG = setting("com.graphaware.module.test.configKey", STRING, "configValue");

    @Override
    public void bootstrap(GraphAwareRuntime runtime, String moduleId, Map<String, String> config) {
        runtime.registerModule(new TestRuntimeModule(moduleId, config));
    }
}