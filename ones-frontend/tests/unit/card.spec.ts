import { shallowMount, Wrapper } from "@vue/test-utils";
import Card from "@/components/Card.vue";

describe("Card.vue", () => {
    it("has no elements without arguments", () => {
        const wrapper: Wrapper<Card> = shallowMount(Card, {
            slots: {}
        });
        expect(wrapper.element.children[0]).toBeUndefined();
    });
});
