export type InputEvent = Event & {
    target: HTMLInputElement
};

export type CheckboxInputEvent = Event & {
    target: {
        value: boolean
    }
};
