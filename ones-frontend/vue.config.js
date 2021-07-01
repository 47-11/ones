module.exports = {
    outputDir: "target/classes/public",
    assetsDir: "assets",
    indexPath: "./index.html",
    productionSourceMap: false,
    configureWebpack: {
        devtool: "source-map"
    },
    pwa: {
        workboxPluginMode: "GenerateSW",
        workboxOptions: {
            skipWaiting: true
        },
        themeColor: "#6366f1",
        msTileColor: "#ffffff00",
        appleMobileWebAppCapable: true,
        iconPaths: {
            favicon32: "img/icons/favicon-32x32.png",
            favicon16: "img/icons/favicon-16x16.png",
            appleTouchIcon: "img/icons/apple-touch-icon-152x152.png",
            maskIcon: "img/icons/safari-pinned-tab.svg",
            msTileImage: "img/icons/icon-150x150.png"
        }
    }
};
