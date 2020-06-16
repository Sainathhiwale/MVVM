package com.dorvis.mvvm.ui.users.allusers;


import com.dorvis.mvvm.data.model.users.UsersList;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class AllUserViewModel extends ViewModel {
    private final AllUserRepository allUserRepository;
    private CompositeDisposable disposable;

    private final MutableLiveData<UsersList> getuserList = new MutableLiveData<>();
    private final MutableLiveData<Boolean> repoLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();

    @Inject
    public AllUserViewModel(AllUserRepository allUserRepository) {
        this.allUserRepository = allUserRepository;
        disposable = new CompositeDisposable();
    }

    public LiveData<UsersList> getUserList() {
        return getuserList;
    }

    public LiveData<Boolean> getRepoLoadError() {
        return repoLoadError;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public void getallUsersInfo(){
        loading.setValue(true);
        disposable.add(allUserRepository.getUserLists().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableSingleObserver<UsersList>(){

                    @Override
                    public void onSuccess(UsersList users) {
                     repoLoadError.setValue(false);
                     getuserList.setValue(users);
                     loading.setValue(false);
                    }

                    @Override
                    public void onError(Throwable e) {
                        repoLoadError.setValue(true);
                        loading.setValue(false);
                    }
                }));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (disposable != null) {
            disposable.clear();
            disposable = null;
        }
    }

}
