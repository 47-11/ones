<template>
    <div id="app" class="font-sans">
        <div class="bg-red-600 text-white text-center p-2 w-full">
            <h2 class="text-lg">
                <font-awesome-icon :icon="'exclamation-triangle'" class="ml-2"/>
                {{ "No connection" }}
            </h2>
            {{ "Looks like you are offline."}}
        </div>
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

.router-link-active, a {
    @apply
    text-indigo-500
    border-b-2
    border-transparent
    hover:border-gray-200
    font-bold;
}
</style>
