<template>
    <div id="app" class="font-sans">
        <router-view/>
    </div>
</template>

<style>
@font-face {
    font-family: "Nunito";
    font-weight: normal;
    src: local("Nunito"), url("./assets/fonts/nunito-regular.ttf");
}

@font-face {
    font-family: "Nunito";
    font-weight: 500;
    src: local("Nunito Medium"), url('./assets/fonts/nunito-medium.ttf');
}

@font-face {
    font-family: "Nunito";
    font-weight: 800;
    src: local("Nunito Bold"), url('./assets/fonts/nunito-bold.ttf');
}
</style>
