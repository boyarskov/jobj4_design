package ru.job4j.generics;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenRoleIsManager() {
        RoleStore store = new RoleStore();
        store.add(new Role("2", "Manager"));
        Role result = store.findById("2");
        assertThat(result.getRoleuser()).isEqualTo("Manager");
    }

    @Test
    void whenAddAndFindThenRoleUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Java dev"));
        Role result = store.findById("2");
        assertThat(result).isNull();
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Java dev"));
        boolean rsl = store.replace("1", new Role("1", "Javascript dev"));
        assertThat(rsl).isTrue();
    }

}