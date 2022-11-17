package com.example.tasty;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public final class ViewPagerAdapter extends FragmentStateAdapter {
    public int getItemCount() {
        return 3;
    }

    @NotNull
    public Fragment createFragment(int position) {
        switch(position) {
            case 0:
                return (Fragment)(new FriendsFragment());
            case 1:
                return (Fragment)(new RecipeFragment());
            default:
                return (Fragment)(new IngredientFragment());
        }
    }

    public ViewPagerAdapter(@NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
}
