package com.example.tipper.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.tipper.R;
import com.example.tipper.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        Button quizButton = binding.quiz;

        View root = binding.getRoot();
        quizButton.setOnClickListener(quizOnClick);

        return root;
    }
    private final View.OnClickListener quizOnClick = new View.OnClickListener() {
        @SuppressLint("DefaultLocale")
        @Override
        public void onClick(View v) {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_navigation);
            navController.navigate(R.id.action_navigation_start_to_quizFragment);
        }
    };
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}