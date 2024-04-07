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
    private final GoogleLibraryAccessors laccForGoogleLibraryAccessors = new GoogleLibraryAccessors(owner);
    private final KotlinxLibraryAccessors laccForKotlinxLibraryAccessors = new KotlinxLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

        /**
         * Creates a dependency provider for activityKtx (androidx.activity:activity-ktx)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getActivityKtx() { return create("activityKtx"); }

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
         * Creates a dependency provider for coreKtx (androidx.core:core)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getCoreKtx() { return create("coreKtx"); }

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
         * Creates a dependency provider for gwallet (com.google.android.gms:play-services-wallet)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getGwallet() { return create("gwallet"); }

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
         * Creates a dependency provider for lifecycleCompose (androidx.lifecycle:lifecycle-runtime-compose)
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getLifecycleCompose() { return create("lifecycleCompose"); }

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
     * Returns the group of libraries at google
     */
    public GoogleLibraryAccessors getGoogle() { return laccForGoogleLibraryAccessors; }

    /**
     * Returns the group of libraries at kotlinx
     */
    public KotlinxLibraryAccessors getKotlinx() { return laccForKotlinxLibraryAccessors; }

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

    public static class GoogleLibraryAccessors extends SubDependencyFactory {
        private final GooglePayLibraryAccessors laccForGooglePayLibraryAccessors = new GooglePayLibraryAccessors(owner);

        public GoogleLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at google.pay
         */
        public GooglePayLibraryAccessors getPay() { return laccForGooglePayLibraryAccessors; }

    }

    public static class GooglePayLibraryAccessors extends SubDependencyFactory {

        public GooglePayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for button (com.google.pay.button:compose-pay-button)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getButton() { return create("google.pay.button"); }

    }

    public static class KotlinxLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesLibraryAccessors laccForKotlinxCoroutinesLibraryAccessors = new KotlinxCoroutinesLibraryAccessors(owner);

        public KotlinxLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.coroutines
         */
        public KotlinxCoroutinesLibraryAccessors getCoroutines() { return laccForKotlinxCoroutinesLibraryAccessors; }

    }

    public static class KotlinxCoroutinesLibraryAccessors extends SubDependencyFactory {
        private final KotlinxCoroutinesPlayLibraryAccessors laccForKotlinxCoroutinesPlayLibraryAccessors = new KotlinxCoroutinesPlayLibraryAccessors(owner);

        public KotlinxCoroutinesLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Returns the group of libraries at kotlinx.coroutines.play
         */
        public KotlinxCoroutinesPlayLibraryAccessors getPlay() { return laccForKotlinxCoroutinesPlayLibraryAccessors; }

    }

    public static class KotlinxCoroutinesPlayLibraryAccessors extends SubDependencyFactory {

        public KotlinxCoroutinesPlayLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

            /**
             * Creates a dependency provider for services (org.jetbrains.kotlinx:kotlinx-coroutines-play-services)
             * This dependency was declared in catalog libs.versions.toml
             */
            public Provider<MinimalExternalModuleDependency> getServices() { return create("kotlinx.coroutines.play.services"); }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final CoreVersionAccessors vaccForCoreVersionAccessors = new CoreVersionAccessors(providers, config);
        private final GoogleVersionAccessors vaccForGoogleVersionAccessors = new GoogleVersionAccessors(providers, config);
        private final KotlinxVersionAccessors vaccForKotlinxVersionAccessors = new KotlinxVersionAccessors(providers, config);
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
             * Returns the version associated to this alias: androidLifecycleCompsoeVersion (2.6.2)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidLifecycleCompsoeVersion() { return getVersion("androidLifecycleCompsoeVersion"); }

            /**
             * Returns the version associated to this alias: androidLifecycleVersion (2.2.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getAndroidLifecycleVersion() { return getVersion("androidLifecycleVersion"); }

            /**
             * Returns the version associated to this alias: composeActivityVersion (1.6.1)
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

        /**
         * Returns the group of versions at versions.core
         */
        public CoreVersionAccessors getCore() { return vaccForCoreVersionAccessors; }

        /**
         * Returns the group of versions at versions.google
         */
        public GoogleVersionAccessors getGoogle() { return vaccForGoogleVersionAccessors; }

        /**
         * Returns the group of versions at versions.kotlinx
         */
        public KotlinxVersionAccessors getKotlinx() { return vaccForKotlinxVersionAccessors; }

    }

    public static class CoreVersionAccessors extends VersionFactory  {

        public CoreVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: core.ktx (1.12.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getKtx() { return getVersion("core.ktx"); }

    }

    public static class GoogleVersionAccessors extends VersionFactory  {

        private final GooglePayVersionAccessors vaccForGooglePayVersionAccessors = new GooglePayVersionAccessors(providers, config);
        public GoogleVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: google.wallet (19.3.0)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getWallet() { return getVersion("google.wallet"); }

        /**
         * Returns the group of versions at versions.google.pay
         */
        public GooglePayVersionAccessors getPay() { return vaccForGooglePayVersionAccessors; }

    }

    public static class GooglePayVersionAccessors extends VersionFactory  {

        public GooglePayVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: google.pay.button (0.1.1)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getButton() { return getVersion("google.pay.button"); }

    }

    public static class KotlinxVersionAccessors extends VersionFactory  {

        private final KotlinxCoroutinesVersionAccessors vaccForKotlinxCoroutinesVersionAccessors = new KotlinxCoroutinesVersionAccessors(providers, config);
        public KotlinxVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.kotlinx.coroutines
         */
        public KotlinxCoroutinesVersionAccessors getCoroutines() { return vaccForKotlinxCoroutinesVersionAccessors; }

    }

    public static class KotlinxCoroutinesVersionAccessors extends VersionFactory  {

        private final KotlinxCoroutinesPlayVersionAccessors vaccForKotlinxCoroutinesPlayVersionAccessors = new KotlinxCoroutinesPlayVersionAccessors(providers, config);
        public KotlinxCoroutinesVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Returns the group of versions at versions.kotlinx.coroutines.play
         */
        public KotlinxCoroutinesPlayVersionAccessors getPlay() { return vaccForKotlinxCoroutinesPlayVersionAccessors; }

    }

    public static class KotlinxCoroutinesPlayVersionAccessors extends VersionFactory  {

        public KotlinxCoroutinesPlayVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

            /**
             * Returns the version associated to this alias: kotlinx.coroutines.play.services (1.7.3)
             * If the version is a rich version and that its not expressible as a
             * single version string, then an empty string is returned.
             * This version was declared in catalog libs.versions.toml
             */
            public Provider<String> getServices() { return getVersion("kotlinx.coroutines.play.services"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
