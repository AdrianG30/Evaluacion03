package com.renato.ec03;
import androidx.fragment.app.Fragment;

public interface NavigationHost {
    void navigateTo(Fragment fragment,boolean addToBackstack);
}