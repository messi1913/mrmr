package com.ddastudio.mrmr.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public ProfileDTO addProfile(ProfileDTO profileDTO, Account account) {
        if(Objects.isNull(profileDTO)) {
            //TODO :
        }
        Profile profile = modelMapper.map(profileDTO, Profile.class);
        profile.setAccount(account);
        profileRepository.save(profile);
        return profileDTO;
    }

    public void deleteProfile(int prfileId, Account account) {
        Profile profile = profileRepository.findByIdAndAccount_Id(prfileId, account.getId())
                .orElseThrow(() -> new UsernameNotFoundException(String.valueOf(prfileId)));
        profileRepository.delete(profile);
    }

}
