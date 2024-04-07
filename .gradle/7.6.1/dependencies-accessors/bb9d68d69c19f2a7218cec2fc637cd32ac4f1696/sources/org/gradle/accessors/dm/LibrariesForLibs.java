package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the `libs` extension.
*/
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for androidCoreTesting (androidx.arch.core:core-testing)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroidCoreTesting() { return create("androidCoreTesting"); }

        /**
         * Creates a dependency provider for androidGradlePlugin (com.android.tools.build:gradle)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAndroidGradlePlugin() { return create("androidGradlePlugin"); }

        /**
         * Creates a dependency provider for appCompat (androidx.appcompat:appcompat)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getAppCompat() { return create("appCompat"); }

        /**
         * Creates a dependency provider for composeActivity (androidx.activity:activity-compose)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getComposeActivity() { return create("composeActivity"); }

        /**
         * Creates a dependency provider for composeJetBrainsGradlePlugin (org.jetbrains.compose:compose-gradle-plugin)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getComposeJetBrainsGradlePlugin() { return create("composeJetBrainsGradlePlugin"); }

        /**
         * Creates a dependency provider for composeMaterial (androidx.compose.material:material)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getComposeMaterial() { return create("composeMaterial"); }

        /**
         * Creates a dependency provider for coroutines (org.jetbrains.kotlinx:kotlinx-coroutines-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCoroutines() { return create("coroutines"); }

        /**
         * Creates a dependency provider for detektGradlePlugin (io.gitlab.arturbosch.detekt:detekt-gradle-plugin)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getDetektGradlePlugin() { return create("detektGradlePlugin"); }

        /**
         * Creates a dependency provider for kotlinGradlePlugin (org.jetbrains.kotlin:kotlin-gradle-plugin)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKotlinGradlePlugin() { return create("kotlinGradlePlugin"); }

        /**
         * Creates a dependency provider for kotlinSerializationGradlePlugin (org.jetbrains.kotlin:kotlin-serialization)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKotlinSerializationGradlePlugin() { return create("kotlinSerializationGradlePlugin"); }

        /**
         * Creates a dependency provider for kotlinTestJUnit (org.jetbrains.kotlin:kotlin-test-junit)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getKotlinTestJUnit() { return create("kotlinTestJUnit"); }

        /**
         * Creates a dependency provider for lifecycle (androidx.lifecycle:lifecycle-extensions)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLifecycle() { return create("lifecycle"); }

        /**
         * Creates a dependency provider for lifecycleRuntime (androidx.lifecycle:lifecycle-runtime-ktx)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLifecycleRuntime() { return create("lifecycleRuntime"); }

        /**
         * Creates a dependency provider for material (com.google.android.material:material)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMaterial() { return create("material"); }

        /**
         * Creates a dependency provider for mobileMultiplatformGradlePlugin (dev.icerock:mobile-multiplatform)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMobileMultiplatformGradlePlugin() { return create("mobileMultiplatformGradlePlugin"); }

        /**
         * Creates a dependency provider for mokoGradlePlugin (dev.icerock.moko:moko-gradle-plugin)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMokoGradlePlugin() { return create("mokoGradlePlugin"); }

        /**
         * Creates a dependency provider for mokoMvvmCore (dev.icerock.moko:mvvm-core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMokoMvvmCore() { return create("mokoMvvmCore"); }

        /**
         * Creates a dependency provider for mokoMvvmTest (dev.icerock.moko:mvvm-test)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getMokoMvvmTest() { return create("mokoMvvmTest"); }

    /**
     * Returns the group of versions at versions
     */
    public VersionAccessors getVersions() { return vaccForVersionAccessors; }

    /**
     * Returns the group of bundles at bundles
     */
    public BundleAccessors getBundles() { return baccForBundleAccessors; }

    /**
     * Returns the group of plugins at plugins
     */
    public PluginAccessors getPlugins() { return paccForPluginAccessors; }

    public static class VersionAccessors extends VersionFactory  {

        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: androidAppCompatVersion (1.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidAppCompatVersion() { return getVersion("androidAppCompatVersion"); }

            /**
             * Returns the version associated to this alias: androidCoreTestingVersion (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidCoreTestingVersion() { return getVersion("androidCoreTestingVersion"); }

            /**
             * Returns the version associated to this alias: androidLifecycleVersion (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidLifecycleVersion() { return getVersion("androidLifecycleVersion"); }

            /**
             * Returns the version associated to this alias: composeActivityVersion (1.7.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getComposeActivityVersion() { return getVersion("composeActivityVersion"); }

            /**
             * Returns the version associated to this alias: composeJetBrainsVersion (1.3.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getComposeJetBrainsVersion() { return getVersion("composeJetBrainsVersion"); }

            /**
             * Returns the version associated to this alias: composeMaterialVersion (1.4.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getComposeMaterialVersion() { return getVersion("composeMaterialVersion"); }

            /**
             * Returns the version associated to this alias: coroutinesVersion (1.6.4)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getCoroutinesVersion() { return getVersion("coroutinesVersion"); }

            /**
             * Returns the version associated to this alias: kotlinVersion (1.8.10)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKotlinVersion() { return getVersion("kotlinVersion"); }

            /**
             * Returns the version associated to this alias: lifecycleRuntime (2.6.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getLifecycleRuntime() { return getVersion("lifecycleRuntime"); }

            /**
             * Returns the version associated to this alias: materialDesignVersion (1.8.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMaterialDesignVersion() { return getVersion("materialDesignVersion"); }

            /**
             * Returns the version associated to this alias: mokoMvvmVersion (0.16.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMokoMvvmVersion() { return getVersion("mokoMvvmVersion"); }

            /**
             * Returns the version associated to this alias: mokoPermissionsVersion (0.17.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getMokoPermissionsVersion() { return getVersion("mokoPermissionsVersion"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
