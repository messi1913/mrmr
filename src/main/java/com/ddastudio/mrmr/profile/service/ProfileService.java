package com.ddastudio.mrmr.profile.service;

import com.ddastudio.mrmr.account.service.AccountService;
import com.ddastudio.mrmr.profile.model.Profile;
import com.ddastudio.mrmr.profile.model.ProfileDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;


/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/11/27
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileService {
    private final ModelMapper modelMapper;
    private final ProfileRepository profileRepository;
    private final AccountService accountService;

    //TODO : 인증 적용후 id -> Account 로 대
    public ProfileDTO addProfile(ProfileDTO profileDTO, int id) throws Exception {
        if(Objects.isNull(profileDTO)) {
        }
        Profile profile = modelMapper.map(profileDTO, Profile.class);
        profile.setAccount(accountService.getAccount(id));
        profileRepository.save(profile);
        return profileDTO;
    }

    public ProfileDTO modifyProfile(ProfileDTO profileDTO, int id) throws Exception {
        if(Objects.isNull(profileDTO)) {
        }
        Profile profile = modelMapper.map(profileDTO, Profile.class);
        profile.setAccount(accountService.getAccount(id));
        profileRepository.save(profile);
        return profileDTO;
    }

    public void deleteProfile(int profileId) throws Exception {
//        Profile profile = profileRepository.findByIdAndAccount_Id(prfileId, account.getId())
//                .orElseThrow(() -> new UsernameNotFoundException(String.valueOf(prfileId)));
        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new Exception(String.valueOf(profileId)));
        profileRepository.delete(profile);
    }

}
