<template>
    <div class="w-full flex flex-col items-center text-2xl font-bold my-16">
        <font-awesome-icon :icon="'exclamation-circle'" class="block text-4xl mb-7 text-indigo-600"/>
        <slot></slot>
        <div class="w-12 h-1 mt-6 bg-indigo-500"></div>
    </div>
</template>
