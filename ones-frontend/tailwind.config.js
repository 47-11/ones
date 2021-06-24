// eslint-disable-next-line @typescript-eslint/no-var-requires
const defaultTheme = require("tailwindcss/defaultTheme");

// eslint-disable-next-line @typescript-eslint/no-var-requires
const colors = require("tailwindcss/colors");

module.exports = {
    purge: [
        "./public/**/*.html",
        "./src/**/*.vue"
    ],
    darkMode: false, // or 'media' or 'class'
    theme: {
        extend: {
            fontSize: {
                "2xs": "0.75rem",
                xs: "0.875rem",
                sm: "0.925rem"
            },
            fontFamily: {
                sans: ["Nunito", ...defaultTheme.fontFamily.sans]
            },
            colors: {
                lime: colors.lime,
                amber: colors.amber
            }
        }
    },
    variants: {
        extend: {
            borderWidth: ["hover"]
        }
    },
    plugins: [require("@tailwindcss/forms")]
};
