/* eslint-disable @typescript-eslint/no-var-requires */
const http = require("http");
const fs = require("fs");
const child = require("child_process");

console.log("(1) Requesting data. Make sure backend is serving api definition at http://localhost:8080/api/docs/v3");
http.get("http://localhost:8080/api/docs/v3", (res) => {
    res.setEncoding("utf8");
    let rawData = "";
    res.on("data", (chunk) => { rawData += chunk; });
    res.on("end", () => {
        console.log("(2) Finished reading data.");
        try {
            const prettyData = JSON.stringify(JSON.parse(rawData), null, 4);
            fs.writeFileSync("./src/openapi/api-spec.json", prettyData);
            console.log("(3) Wrote api-spec.json.");
            child.execSync("mvn generate-resources -DskipCi", { stdio: "inherit" });
            console.log("(4) Finished generating.");
            console.log("(5) Done.");
        } catch (e) {
            console.error(e);
        }
    });
});
