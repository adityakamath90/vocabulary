package bwellthy.vocabulary.network;

import bwellthy.vocabulary.utility.Config;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;


public class RestClient {


    public VocabularyService getVocabService() {
        VocabularyService api = null;
        try {
            api = getRetrofit().create(VocabularyService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return api;
    }

    private static Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.URL_END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
