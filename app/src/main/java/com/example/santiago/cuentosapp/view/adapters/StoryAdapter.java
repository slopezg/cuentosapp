package com.example.santiago.cuentosapp.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.santiago.cuentosapp.R;
import com.example.santiago.cuentosapp.models.modelsDB.Story;
import com.example.santiago.cuentosapp.models.modelsbusiness.StoryModel;
import com.example.santiago.cuentosapp.view.activities.StoryActivity;

import java.util.List;

/**
 * Created by Santiago on 10/20/17.
 */

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryHolder> {

    public Context mContext;
    private List<Story> stories;

    public StoryAdapter(Context mContext, List<Story> stories) {
        this.mContext = mContext;
        this.stories = stories;
    }

    @Override
    public StoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_story, parent, false);
        StoryHolder storyHolder = new StoryHolder(view);
        return storyHolder;
    }

    @Override
    public void onBindViewHolder(StoryHolder holder, int position) {
        holder.bind(stories.get(position).convertToModel());
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class StoryHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView tvStoryTitle;
        private ImageView ivStoryImage;

        public StoryHolder(View itemView) {
            super(itemView);

            tvStoryTitle = itemView.findViewById(R.id.tvStoryTitle);
            ivStoryImage = itemView.findViewById(R.id.ivStoryImage);
            cardView = itemView.findViewById(R.id.cvStory);
        }

        public void bind(final StoryModel story) {
            String uri = "@drawable/" + story.getResourceImage();
            int imageResource = mContext.getResources().getIdentifier(uri, null, mContext.getPackageName());
            tvStoryTitle.setText(story.getName());
            ivStoryImage.setImageResource(imageResource);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, StoryActivity.class);
                    intent.putExtra("Story", story);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
