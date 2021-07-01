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
        exclude: [
            "/api/**"
        ],
        include: [
            "/img/**"
        ]
    }
};
