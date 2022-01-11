<template>
    <div class="min-h-screen flex flex-col sm:justify-center items-center pt-6 sm:pt-0 bg-gray-100">
        <img src="@/assets/logo.png" class="h-20 mb-3">

        <div class="w-full sm:max-w-md mt-6 bg-white shadow-md overflow-hidden sm:rounded-lg">
            <slot></slot>
        </div>

        <div class="mx-auto my-8">
            <a href="/data-policy">
                Datenschutz
            </a>
        </div>
    </div>
</template>
