package com.example.tipper.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.tipper.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {


    private TextView recipe1TextView;
    private TextView recipe2TextView;
    private TextView recipe3TextView;
    private String recipe1 = "  Mix the meats: Use a combination of ground beef and Italian pork sausage for the best flavor.Include chopped mushrooms: Mushrooms release moisture while they cook, so not only does including mushrooms in your meatball mixture add flavor, it helps keep the meatballs from drying out.Use a light hand: Don't over-mix the ingredients or the meatballs will be tough. Work the ingredients just enough so that the mixture comes together.Cook in batches: Rather than crowd the pan, cook the meatballs in batches in a single layer.\n";
    private String recipe2 = " How to Make Lamb Meatballs. These lamb meatballs are seasoned with orange zest, mint, cilantro, cumin, coriander, cinnamon, cayenne, and garlic.Orange zest isn’t especially common in kefta but is a popular fruit in Morocco. When I was there 20 years ago, the freshly squeezed orange juice in the markets just about saved our lives in the heat. In this dish, it boosts the flavor of the meatballs and balances the rich lamb meat.To keep the meatballs moist and to help it bind together, I add in an egg and panade, which is just breadcrumbs soaked in milk. Once shaped, the meatballs are broiled until lightly golden and glazed with pomegranate molasses. Along with the orange zest, the molasses here gives the final dish a sweet and sour tang that cuts through the richness of the lamb. ";
    private String recipe3 = "Prepare the lemons" +
            "Preheat the oven to 350°F" +
            "Make the crust" +
            "Make the filling" +
            "Bake the lemon bars" +
            "Serve";
    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);

        recipe1TextView = binding.textRecipe1;
        recipe2TextView = binding.textRecipe2;
        recipe3TextView = binding.textRecipe3;
        View root = binding.getRoot();

        recipe1TextView.setText(recipe1);
        recipe2TextView.setText(recipe2);
        recipe3TextView.setText(recipe3);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}