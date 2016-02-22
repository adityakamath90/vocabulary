package bwellthy.vocabulary.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface VocabularyService {
    @GET("words.json")
    Call<Vocabulary> getVocabulary();
}
