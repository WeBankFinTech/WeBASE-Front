package com.webank.webase.front.contractStore;

import com.webank.webase.front.contractStore.entity.ContractFolderItem;
import com.webank.webase.front.contractStore.entity.ContractItem;
import com.webank.webase.front.contractStore.entity.StoreItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PresetDataService {

    @Autowired
    private ContractItemRepository contractItemRepository;
    @Autowired
    private ContractFolderRepository contractFolderRepository;
    @Autowired
    private ContractStoreRepository contractStoreRepository;

    public static final Integer toolboxId = 1;
    public static final Integer evidenceId = 2;
    public static final Integer pointsId = 3;


    public void initStoreItem() {
        insertStoreItem(toolboxId,"工具箱","Toolbox","1","toolboxId",
                "工具箱中有常用的工具合约","工具箱中有常用的工具合约",
                "Toolbox Contract suite","Toolbox Contract suite");

        insertStoreItem(evidenceId,"存证应用","Evidence","2","evidenceId",
                "一套区块链存证合约","一套区块链存证合约",
                "Evidence Contract suite","Evidence Contract suite");

        insertStoreItem(pointsId,"积分应用","Points","2","pointsId",
                "一套积分合约","一套积分合约",
                "Points Contract suite","Points Contract suite");
    }

    public void insertStoreItem(long storeId, String storeName, String StoreName_en, String StoreType,
                                String StoreIcon, String StoreDesc, String StoreDetail,String StoreDesc_en,
                                String StoreDetail_en)
    {
        StoreItem storeItem = new StoreItem();
        storeItem.setStoreId(storeId);
        storeItem.setStoreName(storeName);
        storeItem.setStoreName_en(StoreName_en);
        storeItem.setStoreType(StoreType);
        storeItem.setStoreIcon(StoreIcon);
        storeItem.setStoreDesc(StoreDesc);
        storeItem.setStoreDetail(StoreDetail);
        storeItem.setStoreDesc_en(StoreDesc_en);
        storeItem.setStoreDetail_en(StoreDetail_en);
        storeItem.setCreateTime(LocalDateTime.now());
        storeItem.setModifyTime(storeItem.getCreateTime());
        contractStoreRepository.save(storeItem);
    }

    public void initContractFolderItem() {
        Integer contractFolderIndex = 1;
        insertContractFolderItem(contractFolderIndex++,toolboxId,"Tools","Tools",
                "Tools","","");

        insertContractFolderItem(contractFolderIndex++,evidenceId,"Evidence","Evidence",
                "Evidence","Evidence","Evidence");

        insertContractFolderItem(contractFolderIndex++,pointsId,"Points","Points",
                "Points","Points","Points");
    }

    public void insertContractFolderItem(long contractFolderId, long storeId, String contractFolderName, String contractFolderDesc, String contractFolderDetail,
                                         String contractFolderDesc_en, String contractFolderDetail_en)
    {
        ContractFolderItem contractFolderItem = new ContractFolderItem();
        contractFolderItem.setContractFolderId(contractFolderId);
        contractFolderItem.setStoreId(storeId);
        contractFolderItem.setContractFolderName(contractFolderName);
        contractFolderItem.setContractFolderDesc(contractFolderDesc);
        contractFolderItem.setContractFolderDetail(contractFolderDetail);
        contractFolderItem.setContractFolderDesc_en(contractFolderDesc_en);
        contractFolderItem.setContractFolderDetail_en(contractFolderDetail_en);
        contractFolderItem.setCreateTime(LocalDateTime.now());
        contractFolderItem.setModifyTime(contractFolderItem.getCreateTime());
        contractFolderRepository.save(contractFolderItem);

    }

    public void initContractItem() {
        Integer contractIndex = 1;
        //tools
        insertContractItem(contractIndex++,toolboxId,"LibString","LyoKICogQ29weXJpZ2h0IDIwMTQtMjAxOSB0aGUgb3JpZ2luYWwgYXV0aG9yIG9yIGF1dGhvcnMuCiAqCiAqIExpY2Vuc2VkIHVuZGVyIHRoZSBBcGFjaGUgTGljZW5zZSwgVmVyc2lvbiAyLjAgKHRoZSAiTGljZW5zZSIpOwogKiB5b3UgbWF5IG5vdCB1c2UgdGhpcyBmaWxlIGV4Y2VwdCBpbiBjb21wbGlhbmNlIHdpdGggdGhlIExpY2Vuc2UuCiAqIFlvdSBtYXkgb2J0YWluIGEgY29weSBvZiB0aGUgTGljZW5zZSBhdAogKgogKiAgICAgIGh0dHA6Ly93d3cuYXBhY2hlLm9yZy9saWNlbnNlcy9MSUNFTlNFLTIuMAogKgogKiBVbmxlc3MgcmVxdWlyZWQgYnkgYXBwbGljYWJsZSBsYXcgb3IgYWdyZWVkIHRvIGluIHdyaXRpbmcsIHNvZnR3YXJlCiAqIGRpc3RyaWJ1dGVkIHVuZGVyIHRoZSBMaWNlbnNlIGlzIGRpc3RyaWJ1dGVkIG9uIGFuICJBUyBJUyIgQkFTSVMsCiAqIFdJVEhPVVQgV0FSUkFOVElFUyBPUiBDT05ESVRJT05TIE9GIEFOWSBLSU5ELCBlaXRoZXIgZXhwcmVzcyBvciBpbXBsaWVkLgogKiBTZWUgdGhlIExpY2Vuc2UgZm9yIHRoZSBzcGVjaWZpYyBsYW5ndWFnZSBnb3Zlcm5pbmcgcGVybWlzc2lvbnMgYW5kCiAqIGxpbWl0YXRpb25zIHVuZGVyIHRoZSBMaWNlbnNlLgogKiAqLwoKcHJhZ21hIHNvbGlkaXR5IF4wLjQuMjU7CgpsaWJyYXJ5IExpYkFkZHJlc3N7CiAgICAKICAgIGZ1bmN0aW9uIGlzQ29udHJhY3QoYWRkcmVzcyBhY2NvdW50KSBpbnRlcm5hbCB2aWV3IHJldHVybnMoYm9vbCkgewogICAgICAgIHVpbnQyNTYgc2l6ZTsKICAgICAgICBhc3NlbWJseSB7IHNpemUgOj0gZXh0Y29kZXNpemUoYWRkcikgfSAgCiAgICAgICAgcmV0dXJuIHNpemUgPiAwOwogICAgfQoKICAgIGZ1bmN0aW9uIGlzRW1wdHlBZGRyZXNzKGFkZHJlc3MgYWRkcikgaW50ZXJuYWwgcHVyZSByZXR1cm5zKGJvb2wpewogICAgICAgIHJldHVybiBhZGRyID09IGFkZHJlc3MoMCk7CiAgICB9Cn0K",
                "LibString","LibString");
        insertContractItem(contractIndex++,toolboxId,"LibSafeMathForUint256Utils","LyoKICogQ29weXJpZ2h0IDIwMTQtMjAxOSB0aGUgb3JpZ2luYWwgYXV0aG9yIG9yIGF1dGhvcnMuCiAqCiAqIExpY2Vuc2VkIHVuZGVyIHRoZSBBcGFjaGUgTGljZW5zZSwgVmVyc2lvbiAyLjAgKHRoZSAiTGljZW5zZSIpOwogKiB5b3UgbWF5IG5vdCB1c2UgdGhpcyBmaWxlIGV4Y2VwdCBpbiBjb21wbGlhbmNlIHdpdGggdGhlIExpY2Vuc2UuCiAqIFlvdSBtYXkgb2J0YWluIGEgY29weSBvZiB0aGUgTGljZW5zZSBhdAogKgogKiAgICAgIGh0dHA6Ly93d3cuYXBhY2hlLm9yZy9saWNlbnNlcy9MSUNFTlNFLTIuMAogKgogKiBVbmxlc3MgcmVxdWlyZWQgYnkgYXBwbGljYWJsZSBsYXcgb3IgYWdyZWVkIHRvIGluIHdyaXRpbmcsIHNvZnR3YXJlCiAqIGRpc3RyaWJ1dGVkIHVuZGVyIHRoZSBMaWNlbnNlIGlzIGRpc3RyaWJ1dGVkIG9uIGFuICJBUyBJUyIgQkFTSVMsCiAqIFdJVEhPVVQgV0FSUkFOVElFUyBPUiBDT05ESVRJT05TIE9GIEFOWSBLSU5ELCBlaXRoZXIgZXhwcmVzcyBvciBpbXBsaWVkLgogKiBTZWUgdGhlIExpY2Vuc2UgZm9yIHRoZSBzcGVjaWZpYyBsYW5ndWFnZSBnb3Zlcm5pbmcgcGVybWlzc2lvbnMgYW5kCiAqIGxpbWl0YXRpb25zIHVuZGVyIHRoZSBMaWNlbnNlLgogKiAqLwoKcHJhZ21hIHNvbGlkaXR5IF4wLjQuMjU7CgpsaWJyYXJ5IExpYlNhZmVNYXRoRm9yVWludDI1NlV0aWxzIHsKCiAgICBmdW5jdGlvbiBhZGQodWludDI1NiBhLCB1aW50MjU2IGIpIGludGVybmFsIHB1cmUgcmV0dXJucyAodWludDI1NikgewogICAgICAgIHVpbnQyNTYgYyA9IGEgKyBiOwogICAgICAgIHJlcXVpcmUoYyA+PSBhLCAiU2FmZU1hdGhGb3JVaW50MjU2OiBhZGRpdGlvbiBvdmVyZmxvdyIpOwogICAgICAgIHJldHVybiBjOwogICAgfQoKICAgIGZ1bmN0aW9uIHN1Yih1aW50MjU2IGEsIHVpbnQyNTYgYikgaW50ZXJuYWwgcHVyZSByZXR1cm5zICh1aW50MjU2KSB7CiAgICAgICAgcmVxdWlyZShiIDw9IGEsICJTYWZlTWF0aEZvclVpbnQyNTY6IHN1YnRyYWN0aW9uIG92ZXJmbG93Iik7CiAgICAgICAgdWludDI1NiBjID0gYSAtIGI7CiAgICAgICAgcmV0dXJuIGM7CiAgICB9CgogICAgZnVuY3Rpb24gbXVsKHVpbnQyNTYgYSwgdWludDI1NiBiKSBpbnRlcm5hbCBwdXJlIHJldHVybnMgKHVpbnQyNTYpIHsKICAgICAgICBpZiAoYSA9PSAwIHx8IGIgPT0gMCkgewogICAgICAgICAgICByZXR1cm4gMDsKICAgICAgICB9CgogICAgICAgIHVpbnQyNTYgYyA9IGEgKiBiOwogICAgICAgIHJlcXVpcmUoYyAvIGEgPT0gYiwgIlNhZmVNYXRoRm9yVWludDI1NjogbXVsdGlwbGljYXRpb24gb3ZlcmZsb3ciKTsKICAgICAgICByZXR1cm4gYzsKICAgIH0KCiAgICBmdW5jdGlvbiBkaXYodWludDI1NiBhLCB1aW50MjU2IGIpIGludGVybmFsIHB1cmUgcmV0dXJucyAodWludDI1NikgewogICAgICAgIHJlcXVpcmUoYiA+IDAsICJTYWZlTWF0aEZvclVpbnQyNTY6IGRpdmlzaW9uIGJ5IHplcm8iKTsKICAgICAgICB1aW50MjU2IGMgPSBhIC8gYjsKICAgICAgICByZXR1cm4gYzsKICAgIH0KCiAgICBmdW5jdGlvbiBtb2QodWludDI1NiBhLCB1aW50MjU2IGIpIGludGVybmFsIHB1cmUgcmV0dXJucyAodWludDI1NikgewogICAgICAgIHJlcXVpcmUoYiAhPSAwLCAiU2FmZU1hdGhGb3JVaW50MjU2OiBtb2R1bG8gYnkgemVybyIpOwogICAgICAgIHJldHVybiBhICUgYjsKICAgIH0KCiAgICBmdW5jdGlvbiBwb3dlcih1aW50MjU2IGEsIHVpbnQyNTYgYikgaW50ZXJuYWwgcHVyZSByZXR1cm5zICh1aW50MjU2KXsKCiAgICAgICAgaWYoYSA9PSAwKSByZXR1cm4gMDsKICAgICAgICBpZihiID09IDApIHJldHVybiAxOwoKICAgICAgICB1aW50MjU2IGMgPSAxOwogICAgICAgIGZvcih1aW50MjU2IGkgPSAwOyBpIDwgYjsgaSsrKXsKICAgICAgICAgICAgYyA9IG11bChjLCBhKTsKICAgICAgICB9CiAgICB9CgogICAgZnVuY3Rpb24gbWF4KHVpbnQyNTYgYSwgdWludDI1NiBiKSBpbnRlcm5hbCBwdXJlIHJldHVybnMgKHVpbnQyNTYpIHsKICAgICAgICByZXR1cm4gYSA+PSBiID8gYSA6IGI7CiAgICB9CgogICAgZnVuY3Rpb24gbWluKHVpbnQyNTYgYSwgdWludDI1NiBiKSBpbnRlcm5hbCBwdXJlIHJldHVybnMgKHVpbnQyNTYpIHsKICAgICAgICByZXR1cm4gYSA8IGIgPyBhIDogYjsKICAgIH0KCiAgICBmdW5jdGlvbiBhdmVyYWdlKHVpbnQyNTYgYSwgdWludDI1NiBiKSBpbnRlcm5hbCBwdXJlIHJldHVybnMgKHVpbnQyNTYpIHsKICAgICAgICByZXR1cm4gKGEgLyAyKSArIChiIC8gMikgKyAoKGEgJSAyICsgYiAlIDIpIC8gMik7CiAgICB9Cn0K",
                "LibSafeMathForUint256Utils","LibSafeMathForUint256Utils");
        insertContractItem(contractIndex++,toolboxId,"table","cHJhZ21hIHNvbGlkaXR5IF4wLjQuMjQ7Cgpjb250cmFjdCBUYWJsZUZhY3RvcnkgewogICAgZnVuY3Rpb24gb3BlblRhYmxlKHN0cmluZykgcHVibGljIHZpZXcgcmV0dXJucyAoVGFibGUpOyAvL29wZW4gdGFibGUKICAgIGZ1bmN0aW9uIGNyZWF0ZVRhYmxlKHN0cmluZywgc3RyaW5nLCBzdHJpbmcpIHB1YmxpYyByZXR1cm5zIChpbnQyNTYpOyAvL2NyZWF0ZSB0YWJsZQp9CgovL3NlbGVjdCBjb25kaXRpb24KY29udHJhY3QgQ29uZGl0aW9uIHsKICAgIGZ1bmN0aW9uIEVRKHN0cmluZywgaW50MjU2KSBwdWJsaWMgdmlldzsKICAgIGZ1bmN0aW9uIEVRKHN0cmluZywgc3RyaW5nKSBwdWJsaWMgdmlldzsKICAgIGZ1bmN0aW9uIEVRKHN0cmluZywgYWRkcmVzcykgcHVibGljIHZpZXc7CgogICAgZnVuY3Rpb24gTkUoc3RyaW5nLCBpbnQyNTYpIHB1YmxpYyB2aWV3OwogICAgZnVuY3Rpb24gTkUoc3RyaW5nLCBzdHJpbmcpIHB1YmxpYyB2aWV3OwoKICAgIGZ1bmN0aW9uIEdUKHN0cmluZywgaW50MjU2KSBwdWJsaWMgdmlldzsKICAgIGZ1bmN0aW9uIEdFKHN0cmluZywgaW50MjU2KSBwdWJsaWMgdmlldzsKCiAgICBmdW5jdGlvbiBMVChzdHJpbmcsIGludDI1NikgcHVibGljIHZpZXc7CiAgICBmdW5jdGlvbiBMRShzdHJpbmcsIGludDI1NikgcHVibGljIHZpZXc7CgogICAgZnVuY3Rpb24gbGltaXQoaW50MjU2KSBwdWJsaWMgdmlldzsKICAgIGZ1bmN0aW9uIGxpbWl0KGludDI1NiwgaW50MjU2KSBwdWJsaWMgdmlldzsKfQoKLy9vbmUgcmVjb3JkCmNvbnRyYWN0IEVudHJ5IHsKICAgIGZ1bmN0aW9uIGdldEludChzdHJpbmcpIHB1YmxpYyB2aWV3IHJldHVybnMgKGludDI1Nik7CiAgICBmdW5jdGlvbiBnZXRVSW50KHN0cmluZykgcHVibGljIHZpZXcgcmV0dXJucyAodWludDI1Nik7CiAgICBmdW5jdGlvbiBnZXRBZGRyZXNzKHN0cmluZykgcHVibGljIHZpZXcgcmV0dXJucyAoYWRkcmVzcyk7CiAgICBmdW5jdGlvbiBnZXRCeXRlczY0KHN0cmluZykgcHVibGljIHZpZXcgcmV0dXJucyAoYnl0ZXMxWzY0XSk7CiAgICBmdW5jdGlvbiBnZXRCeXRlczMyKHN0cmluZykgcHVibGljIHZpZXcgcmV0dXJucyAoYnl0ZXMzMik7CiAgICBmdW5jdGlvbiBnZXRTdHJpbmcoc3RyaW5nKSBwdWJsaWMgdmlldyByZXR1cm5zIChzdHJpbmcpOwoKICAgIGZ1bmN0aW9uIHNldChzdHJpbmcsIGludDI1NikgcHVibGljOwogICAgZnVuY3Rpb24gc2V0KHN0cmluZywgdWludDI1NikgcHVibGljOwogICAgZnVuY3Rpb24gc2V0KHN0cmluZywgc3RyaW5nKSBwdWJsaWM7CiAgICBmdW5jdGlvbiBzZXQoc3RyaW5nLCBhZGRyZXNzKSBwdWJsaWM7Cn0KCi8vcmVjb3JkIHNldHMKY29udHJhY3QgRW50cmllcyB7CiAgICBmdW5jdGlvbiBnZXQoaW50MjU2KSBwdWJsaWMgdmlldyByZXR1cm5zIChFbnRyeSk7CiAgICBmdW5jdGlvbiBzaXplKCkgcHVibGljIHZpZXcgcmV0dXJucyAoaW50MjU2KTsKfQoKLy9UYWJsZSBtYWluIGNvbnRyYWN0CmNvbnRyYWN0IFRhYmxlIHsKICAgIGZ1bmN0aW9uIHNlbGVjdChzdHJpbmcsIENvbmRpdGlvbikgcHVibGljIHZpZXcgcmV0dXJucyAoRW50cmllcyk7CiAgICBmdW5jdGlvbiBpbnNlcnQoc3RyaW5nLCBFbnRyeSkgcHVibGljIHJldHVybnMgKGludDI1Nik7CiAgICBmdW5jdGlvbiB1cGRhdGUoc3RyaW5nLCBFbnRyeSwgQ29uZGl0aW9uKSBwdWJsaWMgcmV0dXJucyAoaW50MjU2KTsKICAgIGZ1bmN0aW9uIHJlbW92ZShzdHJpbmcsIENvbmRpdGlvbikgcHVibGljIHJldHVybnMgKGludDI1Nik7CgogICAgZnVuY3Rpb24gbmV3RW50cnkoKSBwdWJsaWMgdmlldyByZXR1cm5zIChFbnRyeSk7CiAgICBmdW5jdGlvbiBuZXdDb25kaXRpb24oKSBwdWJsaWMgdmlldyByZXR1cm5zIChDb25kaXRpb24pOwp9Cgpjb250cmFjdCBLVlRhYmxlRmFjdG9yeSB7CiAgICBmdW5jdGlvbiBvcGVuVGFibGUoc3RyaW5nKSBwdWJsaWMgdmlldyByZXR1cm5zIChLVlRhYmxlKTsKICAgIGZ1bmN0aW9uIGNyZWF0ZVRhYmxlKHN0cmluZywgc3RyaW5nLCBzdHJpbmcpIHB1YmxpYyByZXR1cm5zIChpbnQyNTYpOwp9CgovL0tWVGFibGUgcGVyIHBlcm1pYXJ5IGtleSBoYXMgb25seSBvbmUgRW50cnkKY29udHJhY3QgS1ZUYWJsZSB7CiAgICBmdW5jdGlvbiBnZXQoc3RyaW5nKSBwdWJsaWMgdmlldyByZXR1cm5zIChib29sLCBFbnRyeSk7CiAgICBmdW5jdGlvbiBzZXQoc3RyaW5nLCBFbnRyeSkgcHVibGljIHJldHVybnMgKGludDI1Nik7CiAgICBmdW5jdGlvbiBuZXdFbnRyeSgpIHB1YmxpYyB2aWV3IHJldHVybnMgKEVudHJ5KTsKfQo=",
                "table","table");


        //evidence
        insertContractItem(contractIndex++,evidenceId,"Evidence","cHJhZ21hIHNvbGlkaXR5IF4wLjQuNDsKY29udHJhY3QgRXZpZGVuY2VTaWduZXJzRGF0YUFCSXsgZnVuY3Rpb24gdmVyaWZ5KGFkZHJlc3MgYWRkcilwdWJsaWMgY29uc3RhbnQgcmV0dXJucyhib29sKXt9CmZ1bmN0aW9uIGdldFNpZ25lcih1aW50IGluZGV4KXB1YmxpYyBjb25zdGFudCByZXR1cm5zKGFkZHJlc3Mpe30gCmZ1bmN0aW9uIGdldFNpZ25lcnNTaXplKCkgcHVibGljIGNvbnN0YW50IHJldHVybnModWludCl7fQp9Cgpjb250cmFjdCBFdmlkZW5jZXsKICAgIAogICAgc3RyaW5nIGV2aWRlbmNlOwogICAgc3RyaW5nIGV2aWRlbmNlSW5mbzsKICAgIHN0cmluZyBldmlkZW5jZUlkOwogICAgdWludDhbXSBfdjsKICAgIGJ5dGVzMzJbXSBfcjsKICAgIGJ5dGVzMzJbXSBfczsKICAgIGFkZHJlc3NbXSBzaWduZXJzOwogICAgYWRkcmVzcyBwdWJsaWMgc2lnbmVyc0FkZHI7CiAgICAKICAgICAgICBldmVudCBhZGRTaWduYXR1cmVzRXZlbnQoc3RyaW5nIGV2aSwgc3RyaW5nIGluZm8sIHN0cmluZyBpZCwgdWludDggdiwgYnl0ZXMzMiByLCBieXRlczMyIHMpOwogICAgICAgIGV2ZW50IG5ld1NpZ25hdHVyZXNFdmVudChzdHJpbmcgZXZpLCBzdHJpbmcgaW5mbywgc3RyaW5nIGlkLCB1aW50OCB2LCBieXRlczMyIHIsIGJ5dGVzMzIgcyxhZGRyZXNzIGFkZHIpOwogICAgICAgIGV2ZW50IGVycm9yTmV3U2lnbmF0dXJlc0V2ZW50KHN0cmluZyBldmksIHN0cmluZyBpbmZvLCBzdHJpbmcgaWQsIHVpbnQ4IHYsIGJ5dGVzMzIgciwgYnl0ZXMzMiBzLGFkZHJlc3MgYWRkcik7CiAgICAgICAgZXZlbnQgZXJyb3JBZGRTaWduYXR1cmVzRXZlbnQoc3RyaW5nIGV2aSwgc3RyaW5nIGluZm8sIHN0cmluZyBpZCwgdWludDggdiwgYnl0ZXMzMiByLCBieXRlczMyIHMsYWRkcmVzcyBhZGRyKTsKICAgICAgICBldmVudCBhZGRSZXBlYXRTaWduYXR1cmVzRXZlbnQoc3RyaW5nIGV2aSwgc3RyaW5nIGluZm8sIHN0cmluZyBpZCwgdWludDggdiwgYnl0ZXMzMiByLCBieXRlczMyIHMpOwogICAgICAgIGV2ZW50IGVycm9yUmVwZWF0U2lnbmF0dXJlc0V2ZW50KHN0cmluZyBldmksIHN0cmluZyBpZCwgdWludDggdiwgYnl0ZXMzMiByLCBieXRlczMyIHMsIGFkZHJlc3MgYWRkcik7CgogICAgZnVuY3Rpb24gQ2FsbFZlcmlmeShhZGRyZXNzIGFkZHIpIHB1YmxpYyBjb25zdGFudCByZXR1cm5zKGJvb2wpIHsKICAgICAgICByZXR1cm4gRXZpZGVuY2VTaWduZXJzRGF0YUFCSShzaWduZXJzQWRkcikudmVyaWZ5KGFkZHIpOwogICAgfQoKICAgICAgIGZ1bmN0aW9uIEV2aWRlbmNlKHN0cmluZyBldmksIHN0cmluZyBpbmZvLCBzdHJpbmcgaWQsIHVpbnQ4IHYsIGJ5dGVzMzIgciwgYnl0ZXMzMiBzLCBhZGRyZXNzIGFkZHIsIGFkZHJlc3Mgc2VuZGVyKSBwdWJsaWMgewogICAgICAgc2lnbmVyc0FkZHIgPSBhZGRyOwogICAgICAgaWYoQ2FsbFZlcmlmeShzZW5kZXIpKQogICAgICAgewogICAgICAgICAgIGV2aWRlbmNlID0gZXZpOwogICAgICAgICAgIGV2aWRlbmNlSW5mbyA9IGluZm87CiAgICAgICAgICAgZXZpZGVuY2VJZCA9IGlkOwogICAgICAgICAgIF92LnB1c2godik7CiAgICAgICAgICAgX3IucHVzaChyKTsKICAgICAgICAgICBfcy5wdXNoKHMpOwogICAgICAgICAgIHNpZ25lcnMucHVzaChzZW5kZXIpOwogICAgICAgICAgIG5ld1NpZ25hdHVyZXNFdmVudChldmksaW5mbyxpZCx2LHIscyxhZGRyKTsKICAgICAgIH0KICAgICAgIGVsc2UKICAgICAgIHsKICAgICAgICAgICBlcnJvck5ld1NpZ25hdHVyZXNFdmVudChldmksaW5mbyxpZCx2LHIscyxhZGRyKTsKICAgICAgIH0KICAgIH0KCiAgICAgICAgZnVuY3Rpb24gZ2V0RXZpZGVuY2VJbmZvKCkgcHVibGljIGNvbnN0YW50IHJldHVybnMoc3RyaW5nKXsKICAgICAgICAgICAgcmV0dXJuIGV2aWRlbmNlSW5mbzsKICAgIH0KCiAgICBmdW5jdGlvbiBnZXRFdmlkZW5jZSgpIHB1YmxpYyBjb25zdGFudCByZXR1cm5zKHN0cmluZyxzdHJpbmcsc3RyaW5nLHVpbnQ4W10sYnl0ZXMzMltdLGJ5dGVzMzJbXSxhZGRyZXNzW10pewogICAgICAgIHVpbnQgbGVuZ3RoID0gRXZpZGVuY2VTaWduZXJzRGF0YUFCSShzaWduZXJzQWRkcikuZ2V0U2lnbmVyc1NpemUoKTsKICAgICAgICAgYWRkcmVzc1tdIG1lbW9yeSBzaWduZXJMaXN0ID0gbmV3IGFkZHJlc3NbXShsZW5ndGgpOwogICAgICAgICBmb3IodWludCBpPSAwIDtpPGxlbmd0aCA7aSsrKQogICAgICAgICB7CiAgICAgICAgICAgICBzaWduZXJMaXN0W2ldID0gKEV2aWRlbmNlU2lnbmVyc0RhdGFBQkkoc2lnbmVyc0FkZHIpLmdldFNpZ25lcihpKSk7CiAgICAgICAgIH0KICAgICAgICByZXR1cm4oZXZpZGVuY2UsZXZpZGVuY2VJbmZvLGV2aWRlbmNlSWQsX3YsX3IsX3Msc2lnbmVyTGlzdCk7CiAgICB9CgogICAgZnVuY3Rpb24gYWRkU2lnbmF0dXJlcyh1aW50OCB2LCBieXRlczMyIHIsIGJ5dGVzMzIgcykgcHVibGljIHJldHVybnMoYm9vbCkgewogICAgICAgIGZvcih1aW50IGk9IDAgO2k8c2lnbmVycy5sZW5ndGggO2krKykKICAgICAgICB7CiAgICAgICAgICAgIGlmKG1zZy5zZW5kZXIgPT0gc2lnbmVyc1tpXSkKICAgICAgICAgICAgewogICAgICAgICAgICAgICAgaWYoIF92W2ldID09IHYgJiYgX3JbaV0gPT0gciAmJiBfc1tpXSA9PSBzKQogICAgICAgICAgICAgICAgewogICAgICAgICAgICAgICAgICAgIGFkZFJlcGVhdFNpZ25hdHVyZXNFdmVudChldmlkZW5jZSxldmlkZW5jZUluZm8sZXZpZGVuY2VJZCx2LHIscyk7CiAgICAgICAgICAgICAgICAgICAgcmV0dXJuIHRydWU7CiAgICAgICAgICAgICAgICB9CiAgICAgICAgICAgICAgICBlbHNlCiAgICAgICAgICAgICAgICB7CiAgICAgICAgICAgICAgICAgICAgIGVycm9yUmVwZWF0U2lnbmF0dXJlc0V2ZW50KGV2aWRlbmNlLGV2aWRlbmNlSWQsdixyLHMsbXNnLnNlbmRlcik7CiAgICAgICAgICAgICAgICAgICAgIHJldHVybiBmYWxzZTsKICAgICAgICAgICAgICAgIH0KICAgICAgICAgICAgfQogICAgICAgIH0KICAgICAgIGlmKENhbGxWZXJpZnkobXNnLnNlbmRlcikpCiAgICAgICB7CiAgICAgICAgICAgIF92LnB1c2godik7CiAgICAgICAgICAgIF9yLnB1c2gocik7CiAgICAgICAgICAgIF9zLnB1c2gocyk7CiAgICAgICAgICAgIHNpZ25lcnMucHVzaChtc2cuc2VuZGVyKTsKICAgICAgICAgICAgYWRkU2lnbmF0dXJlc0V2ZW50KGV2aWRlbmNlLGV2aWRlbmNlSW5mbyxldmlkZW5jZUlkLHYscixzKTsKICAgICAgICAgICAgcmV0dXJuIHRydWU7CiAgICAgICB9CiAgICAgICBlbHNlCiAgICAgICB7CiAgICAgICAgICAgZXJyb3JBZGRTaWduYXR1cmVzRXZlbnQoZXZpZGVuY2UsZXZpZGVuY2VJbmZvLGV2aWRlbmNlSWQsdixyLHMsbXNnLnNlbmRlcik7CiAgICAgICAgICAgcmV0dXJuIGZhbHNlOwogICAgICAgfQogICAgfQogICAgCiAgICBmdW5jdGlvbiBnZXRTaWduZXJzKClwdWJsaWMgY29uc3RhbnQgcmV0dXJucyhhZGRyZXNzW10pCiAgICB7CiAgICAgICAgIHVpbnQgbGVuZ3RoID0gRXZpZGVuY2VTaWduZXJzRGF0YUFCSShzaWduZXJzQWRkcikuZ2V0U2lnbmVyc1NpemUoKTsKICAgICAgICAgYWRkcmVzc1tdIG1lbW9yeSBzaWduZXJMaXN0ID0gbmV3IGFkZHJlc3NbXShsZW5ndGgpOwogICAgICAgICBmb3IodWludCBpPSAwIDtpPGxlbmd0aCA7aSsrKQogICAgICAgICB7CiAgICAgICAgICAgICBzaWduZXJMaXN0W2ldID0gKEV2aWRlbmNlU2lnbmVyc0RhdGFBQkkoc2lnbmVyc0FkZHIpLmdldFNpZ25lcihpKSk7CiAgICAgICAgIH0KICAgICAgICAgcmV0dXJuIHNpZ25lckxpc3Q7CiAgICB9Cn0=",
                "Evidence","Evidence");
        insertContractItem(contractIndex++,evidenceId,"EvidenceSignersData","cHJhZ21hIHNvbGlkaXR5IF4wLjQuNDsKaW1wb3J0ICJFdmlkZW5jZS5zb2wiOwoKY29udHJhY3QgRXZpZGVuY2VTaWduZXJzRGF0YXsKICAgICAgICBhZGRyZXNzW10gc2lnbmVyczsKCQlldmVudCBuZXdFdmlkZW5jZUV2ZW50KGFkZHJlc3MgYWRkcik7CiAgICAgICAgZnVuY3Rpb24gbmV3RXZpZGVuY2Uoc3RyaW5nIGV2aSwgc3RyaW5nIGluZm8sc3RyaW5nIGlkLHVpbnQ4IHYsIGJ5dGVzMzIgcixieXRlczMyIHMpcHVibGljIHJldHVybnMoYWRkcmVzcykKICAgICAgICB7CiAgICAgICAgICAgIEV2aWRlbmNlIGV2aWRlbmNlID0gbmV3IEV2aWRlbmNlKGV2aSwgaW5mbywgaWQsIHYsIHIsIHMsIHRoaXMsIG1zZy5zZW5kZXIpOwogICAgICAgICAgICBuZXdFdmlkZW5jZUV2ZW50KGV2aWRlbmNlKTsKICAgICAgICAgICAgcmV0dXJuIGV2aWRlbmNlOwogICAgICAgIH0KCiAgICAgICAgZnVuY3Rpb24gRXZpZGVuY2VTaWduZXJzRGF0YShhZGRyZXNzW10gZXZpZGVuY2VTaWduZXJzKXB1YmxpY3sKICAgICAgICAgICAgZm9yKHVpbnQgaT0wOyBpPGV2aWRlbmNlU2lnbmVycy5sZW5ndGg7ICsraSkgewogICAgICAgICAgICBzaWduZXJzLnB1c2goZXZpZGVuY2VTaWduZXJzW2ldKTsKCQkJfQoJCX0KCiAgICBmdW5jdGlvbiB2ZXJpZnkoYWRkcmVzcyBhZGRyKXB1YmxpYyBjb25zdGFudCByZXR1cm5zKGJvb2wpewogICAgZm9yKHVpbnQgaT0wOyBpPHNpZ25lcnMubGVuZ3RoOyArK2kpIHsKICAgICAgICBpZiAoYWRkciA9PSBzaWduZXJzW2ldKQogICAgICAgIHsKICAgICAgICAgICAgcmV0dXJuIHRydWU7CiAgICAgICAgfQogICAgfQogICAgcmV0dXJuIGZhbHNlOwp9CgogICAgZnVuY3Rpb24gZ2V0U2lnbmVyKHVpbnQgaW5kZXgpcHVibGljIGNvbnN0YW50IHJldHVybnMoYWRkcmVzcyl7CiAgICAgICAgdWludCBsaXN0U2l6ZSA9IHNpZ25lcnMubGVuZ3RoOwogICAgICAgIGlmKGluZGV4IDwgbGlzdFNpemUpCiAgICAgICAgewogICAgICAgICAgICByZXR1cm4gc2lnbmVyc1tpbmRleF07CiAgICAgICAgfQogICAgICAgIGVsc2UKICAgICAgICB7CiAgICAgICAgICAgIHJldHVybiAwOwogICAgICAgIH0KCiAgICB9CgogICAgZnVuY3Rpb24gZ2V0U2lnbmVyc1NpemUoKSBwdWJsaWMgY29uc3RhbnQgcmV0dXJucyh1aW50KXsKICAgICAgICByZXR1cm4gc2lnbmVycy5sZW5ndGg7CiAgICB9CgogICAgZnVuY3Rpb24gZ2V0U2lnbmVycygpIHB1YmxpYyBjb25zdGFudCByZXR1cm5zKGFkZHJlc3NbXSl7CiAgICAgICAgcmV0dXJuIHNpZ25lcnM7CiAgICB9Cgp9",
                "EvidenceSignersData","EvidenceSignersData");

        //Points
        insertContractItem(contractIndex++,pointsId,"Address","cHJhZ21hIHNvbGlkaXR5IF4wLjQuMjU7CgpsaWJyYXJ5IEFkZHJlc3MgewoKICBmdW5jdGlvbiBpc0NvbnRyYWN0KGFkZHJlc3MgYWNjb3VudCkgaW50ZXJuYWwgdmlldyByZXR1cm5zIChib29sKSB7CiAgdWludDI1NiBzaXplOwoKICBhc3NlbWJseSB7IHNpemUgOj0gZXh0Y29kZXNpemUoYWNjb3VudCkgfQpyZXR1cm4gc2l6ZSA+IDA7Cn0KfQoK",
                "Address","Address");
        insertContractItem(contractIndex++,pointsId,"BAC001","cHJhZ21hIHNvbGlkaXR5IF4wLjQuMjU7CgppbXBvcnQgIi4vU2FmZU1hdGguc29sIjsKaW1wb3J0ICIuL1JvbGVzLnNvbCI7CmltcG9ydCAiLi9BZGRyZXNzLnNvbCI7Cgpjb250cmFjdCBJc3N1ZXJSb2xlIHsKICAgIHVzaW5nIFJvbGVzIGZvciBSb2xlcy5Sb2xlOwoKICAgIGV2ZW50IElzc3VlckFkZGVkKGFkZHJlc3MgaW5kZXhlZCBhY2NvdW50KTsKICAgIGV2ZW50IElzc3VlclJlbW92ZWQoYWRkcmVzcyBpbmRleGVkIGFjY291bnQpOwoKICAgIFJvbGVzLlJvbGUgcHJpdmF0ZSBfaXNzdWVyczsKCiAgICBjb25zdHJ1Y3RvciAoKSBpbnRlcm5hbCB7CiAgICAgICAgX2FkZElzc3Vlcihtc2cuc2VuZGVyKTsKICAgIH0KCiAgICBtb2RpZmllciBvbmx5SXNzdWVyKCkgewogICAgICAgIHJlcXVpcmUoaXNJc3N1ZXIobXNnLnNlbmRlciksICJJc3N1ZXJSb2xlOiBjYWxsZXIgZG9lcyBub3QgaGF2ZSB0aGUgSXNzdWVyIHJvbGUiKTsKICAgICAgICBfOwogICAgfQoKICAgIGZ1bmN0aW9uIGlzSXNzdWVyKGFkZHJlc3MgYWNjb3VudCkgcHVibGljIHZpZXcgcmV0dXJucyAoYm9vbCkgewogICAgICAgIHJldHVybiBfaXNzdWVycy5oYXMoYWNjb3VudCk7CiAgICB9CgogICAgZnVuY3Rpb24gYWRkSXNzdWVyKGFkZHJlc3MgYWNjb3VudCkgcHVibGljIG9ubHlJc3N1ZXIgewogICAgICAgIF9hZGRJc3N1ZXIoYWNjb3VudCk7CiAgICB9CgogICAgZnVuY3Rpb24gcmVub3VuY2VJc3N1ZXIoKSBwdWJsaWMgewogICAgICAgIF9yZW1vdmVJc3N1ZXIobXNnLnNlbmRlcik7CiAgICB9CgogICAgZnVuY3Rpb24gX2FkZElzc3VlcihhZGRyZXNzIGFjY291bnQpIGludGVybmFsIHsKICAgICAgICBfaXNzdWVycy5hZGQoYWNjb3VudCk7CiAgICAgICAgZW1pdCBJc3N1ZXJBZGRlZChhY2NvdW50KTsKICAgIH0KCiAgICBmdW5jdGlvbiBfcmVtb3ZlSXNzdWVyKGFkZHJlc3MgYWNjb3VudCkgaW50ZXJuYWwgewogICAgICAgIF9pc3N1ZXJzLnJlbW92ZShhY2NvdW50KTsKICAgICAgICBlbWl0IElzc3VlclJlbW92ZWQoYWNjb3VudCk7CiAgICB9Cn0KCmNvbnRyYWN0IFN1c3BlbmRlclJvbGUgewogICAgdXNpbmcgUm9sZXMgZm9yIFJvbGVzLlJvbGU7CgogICAgZXZlbnQgU3VzcGVuZGVyQWRkZWQoYWRkcmVzcyBpbmRleGVkIGFjY291bnQpOwogICAgZXZlbnQgU3VzcGVuZGVyUmVtb3ZlZChhZGRyZXNzIGluZGV4ZWQgYWNjb3VudCk7CgogICAgUm9sZXMuUm9sZSBwcml2YXRlIF9zdXNwZW5kZXJzOwoKICAgIGNvbnN0cnVjdG9yICgpIGludGVybmFsIHsKICAgICAgICBfYWRkU3VzcGVuZGVyKG1zZy5zZW5kZXIpOwogICAgfQoKICAgIG1vZGlmaWVyIG9ubHlTdXNwZW5kZXIoKSB7CiAgICAgICAgcmVxdWlyZShpc1N1c3BlbmRlcihtc2cuc2VuZGVyKSwgIlN1c3BlbmRlclJvbGU6IGNhbGxlciBkb2VzIG5vdCBoYXZlIHRoZSBTdXNwZW5kZXIgcm9sZSIpOwogICAgICAgIF87CiAgICB9CgogICAgZnVuY3Rpb24gaXNTdXNwZW5kZXIoYWRkcmVzcyBhY2NvdW50KSBwdWJsaWMgdmlldyByZXR1cm5zIChib29sKSB7CiAgICAgICAgcmV0dXJuIF9zdXNwZW5kZXJzLmhhcyhhY2NvdW50KTsKICAgIH0KCiAgICBmdW5jdGlvbiBhZGRTdXNwZW5kZXIoYWRkcmVzcyBhY2NvdW50KSBwdWJsaWMgb25seVN1c3BlbmRlciB7CiAgICAgICAgX2FkZFN1c3BlbmRlcihhY2NvdW50KTsKICAgIH0KCiAgICBmdW5jdGlvbiByZW5vdW5jZVN1c3BlbmRlcigpIHB1YmxpYyB7CiAgICAgICAgX3JlbW92ZVN1c3BlbmRlcihtc2cuc2VuZGVyKTsKICAgIH0KCiAgICBmdW5jdGlvbiBfYWRkU3VzcGVuZGVyKGFkZHJlc3MgYWNjb3VudCkgaW50ZXJuYWwgewogICAgICAgIF9zdXNwZW5kZXJzLmFkZChhY2NvdW50KTsKICAgICAgICBlbWl0IFN1c3BlbmRlckFkZGVkKGFjY291bnQpOwogICAgfQoKICAgIGZ1bmN0aW9uIF9yZW1vdmVTdXNwZW5kZXIoYWRkcmVzcyBhY2NvdW50KSBpbnRlcm5hbCB7CiAgICAgICAgX3N1c3BlbmRlcnMucmVtb3ZlKGFjY291bnQpOwogICAgICAgIGVtaXQgU3VzcGVuZGVyUmVtb3ZlZChhY2NvdW50KTsKICAgIH0KfQoKY29udHJhY3QgU3VzcGVuZGFibGUgaXMgU3VzcGVuZGVyUm9sZSB7CgogICAgZXZlbnQgU3VzcGVuZGVkKGFkZHJlc3MgYWNjb3VudCk7CiAgICBldmVudCBVblN1c3BlbmRlZChhZGRyZXNzIGFjY291bnQpOwoKICAgIGJvb2wgcHJpdmF0ZSBfc3VzcGVuZGVkOwoKICAgIGNvbnN0cnVjdG9yICgpIGludGVybmFsIHsKICAgICAgICBfc3VzcGVuZGVkID0gZmFsc2U7CiAgICB9CgogICAgLyoqCiAgICAgKiBAcmV0dXJuIFRydWUgaWYgdGhlIGNvbnRyYWN0IGlzIHN1c3BlbmRlZCwgZmFsc2Ugb3RoZXJ3aXNlLgogICAgICovCiAgICBmdW5jdGlvbiBzdXNwZW5kZWQoKSBwdWJsaWMgdmlldyByZXR1cm5zIChib29sKSB7CiAgICAgICAgcmV0dXJuIF9zdXNwZW5kZWQ7CiAgICB9CgogICAgLyoqCiAgICAgKiBAZGV2IE1vZGlmaWVyIHRvIG1ha2UgYSBmdW5jdGlvbiBjYWxsYWJsZSBvbmx5IHdoZW4gdGhlIGNvbnRyYWN0IGlzIG5vdCBzdXNwZW5kZWQuCiAgICAgKi8KICAgIG1vZGlmaWVyIHdoZW5Ob3RTdXNwZW5kZWQoKSB7CiAgICAgICAgcmVxdWlyZSghX3N1c3BlbmRlZCwgIlN1c3BlbmRhYmxlOiBzdXNwZW5kZWQiKTsKICAgICAgICBfOwogICAgfQoKICAgIC8qKgogICAgICogQGRldiBNb2RpZmllciB0byBtYWtlIGEgZnVuY3Rpb24gY2FsbGFibGUgb25seSB3aGVuIHRoZSBjb250cmFjdCBpcyBzdXNwZW5kZWQuCiAgICAgKi8KICAgIG1vZGlmaWVyIHdoZW5TdXNwZW5kZWQoKSB7CiAgICAgICAgcmVxdWlyZShfc3VzcGVuZGVkLCAiU3VzcGVuZGFibGU6IG5vdCBzdXNwZW5kZWQiKTsKICAgICAgICBfOwogICAgfQoKICAgIC8qKgogICAgICogQGRldiBDYWxsZWQgYnkgYSBTdXNwZW5kZXIgdG8gc3VzcGVuZCwgdHJpZ2dlcnMgc3RvcHBlZCBzdGF0ZS4KICAgICAqLwogICAgZnVuY3Rpb24gc3VzcGVuZCgpIHB1YmxpYyBvbmx5U3VzcGVuZGVyIHdoZW5Ob3RTdXNwZW5kZWQgewogICAgICAgIF9zdXNwZW5kZWQgPSB0cnVlOwogICAgICAgIGVtaXQgU3VzcGVuZGVkKG1zZy5zZW5kZXIpOwogICAgfQoKICAgIC8qKgogICAgICogQGRldiBDYWxsZWQgYnkgYSBTdXNwZW5kZXIgdG8gdW5TdXNwZW5kLCByZXR1cm5zIHRvIG5vcm1hbCBzdGF0ZS4KICAgICAqLwogICAgZnVuY3Rpb24gdW5TdXNwZW5kKCkgcHVibGljIG9ubHlTdXNwZW5kZXIgd2hlblN1c3BlbmRlZCB7CiAgICAgICAgX3N1c3BlbmRlZCA9IGZhbHNlOwogICAgICAgIGVtaXQgVW5TdXNwZW5kZWQobXNnLnNlbmRlcik7CiAgICB9Cn0KCmNvbnRyYWN0IElCQUMwMDFSZWNlaXZlciB7CiAgICAvKioKICAgICAqIEBub3RpY2UgSGFuZGxlIHRoZSByZWNlaXB0IG9mIGFuIE5GVAogICAgICogQGRldiBUaGUgQkFDMDAxIHNtYXJ0IGNvbnRyYWN0IGNhbGxzIHRoaXMgZnVuY3Rpb24gb24gdGhlIHJlY2lwaWVudAogICAgICovCiAgICBmdW5jdGlvbiBvbkJBQzAwMVJlY2VpdmVkKGFkZHJlc3Mgb3BlcmF0b3IsIGFkZHJlc3MgZnJvbSwgdWludDI1NiB2YWx1ZSwgYnl0ZXMgZGF0YSkKICAgIHB1YmxpYyByZXR1cm5zIChieXRlczQpOwp9Cgpjb250cmFjdCBCQUMwMDFIb2xkZXIgaXMgSUJBQzAwMVJlY2VpdmVyIHsKICAgIGZ1bmN0aW9uIG9uQkFDMDAxUmVjZWl2ZWQoYWRkcmVzcywgYWRkcmVzcywgdWludDI1NiwgYnl0ZXMpIHB1YmxpYyByZXR1cm5zIChieXRlczQpIHsKICAgICAgICByZXR1cm4gdGhpcy5vbkJBQzAwMVJlY2VpdmVkLnNlbGVjdG9yOwogICAgfQp9CgoKLyoqCiAqIEB0aXRsZSBTdGFuZGFyZCBCQUMwMDEgYXNzZXQKICovCmNvbnRyYWN0IEJBQzAwMSBpcyBJc3N1ZXJSb2xlLCBTdXNwZW5kYWJsZSB7CiAgICB1c2luZyBTYWZlTWF0aCBmb3IgdWludDI1NjsKICAgIHVzaW5nIEFkZHJlc3MgZm9yIGFkZHJlc3M7CgogICAgbWFwcGluZyhhZGRyZXNzID0+IHVpbnQyNTYpIHByaXZhdGUgX2JhbGFuY2VzOwogICAgbWFwcGluZyhhZGRyZXNzID0+IG1hcHBpbmcoYWRkcmVzcyA9PiB1aW50MjU2KSkgcHJpdmF0ZSBfYWxsb3dlZDsKICAgIHVpbnQyNTYgcHJpdmF0ZSBfdG90YWxBbW91bnQ7CiAgICBzdHJpbmcgcHJpdmF0ZSBfZGVzY3JpcHRpb247CiAgICBzdHJpbmcgcHJpdmF0ZSBfc2hvcnROYW1lOwogICAgdWludDggcHJpdmF0ZSAgX21pblVuaXQ7CgogICAgLy8gRXF1YWxzIHRvIGBieXRlczQoa2VjY2FrMjU2KCJvbkJBQzAwMVJlY2VpdmVkKGFkZHJlc3MsYWRkcmVzcyx1aW50MjU2LGJ5dGVzKSIpKWAKICAgIGJ5dGVzNCBwcml2YXRlIGNvbnN0YW50IF9CQUMwMDFfUkVDRUlWRUQgPSAweGM3M2QxNmFlOwoKCiAgICBldmVudCBTZW5kKCBhZGRyZXNzIGluZGV4ZWQgZnJvbSwgYWRkcmVzcyBpbmRleGVkIHRvLCB1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKTsKICAgIGV2ZW50IEFwcHJvdmFsKCBhZGRyZXNzIGluZGV4ZWQgb3duZXIsIGFkZHJlc3MgaW5kZXhlZCBzcGVuZGVyLCB1aW50MjU2IHZhbHVlKTsKCgogICAgY29uc3RydWN0b3Ioc3RyaW5nIG1lbW9yeSBkZXNjcmlwdGlvbiwgc3RyaW5nIG1lbW9yeSBzaG9ydE5hbWUsIHVpbnQ4IG1pblVuaXQsIHVpbnQyNTYgdG90YWxBbW91bnQpIHB1YmxpYyB7CiAgICAgICAgX2Rlc2NyaXB0aW9uID0gZGVzY3JpcHRpb247CiAgICAgICAgX3Nob3J0TmFtZSA9IHNob3J0TmFtZTsKICAgICAgICBfbWluVW5pdCA9IG1pblVuaXQ7CiAgICAgICAgX2lzc3VlKG1zZy5zZW5kZXIsIHRvdGFsQW1vdW50ICogKDEwICoqIHVpbnQyNTYobWluVW5pdCkpLCAiIik7CiAgICB9CgoKICAgIGZ1bmN0aW9uIHRvdGFsQW1vdW50KCkgcHVibGljIHZpZXcgcmV0dXJucyAodWludDI1NikgewogICAgICAgIHJldHVybiBfdG90YWxBbW91bnQ7CiAgICB9CgogICAgZnVuY3Rpb24gYmFsYW5jZShhZGRyZXNzIG93bmVyKSBwdWJsaWMgdmlldyByZXR1cm5zICh1aW50MjU2KSB7CiAgICAgICAgcmV0dXJuIF9iYWxhbmNlc1tvd25lcl07CiAgICB9CgogICAgLyoqCiAgICAgKiBAZGV2IEZ1bmN0aW9uIHRvIGNoZWNrIHRoZSBhbW91bnQgb2YgYXNzZXRzIHRoYXQgYW4gb3duZXIgYWxsb3dlZCB0byBhIHNwZW5kZXIuCiAgICAgKi8KICAgIGZ1bmN0aW9uIGFsbG93YW5jZShhZGRyZXNzIG93bmVyLCBhZGRyZXNzIHNwZW5kZXIpIHB1YmxpYyB2aWV3IHJldHVybnMgKHVpbnQyNTYpIHsKICAgICAgICByZXR1cm4gX2FsbG93ZWRbb3duZXJdW3NwZW5kZXJdOwogICAgfQoKICAgIGZ1bmN0aW9uIHNlbmQoYWRkcmVzcyB0bywgdWludDI1NiB2YWx1ZSwgYnl0ZXMgZGF0YSkgcHVibGljIHdoZW5Ob3RTdXNwZW5kZWQgewogICAgICAgIF9zZW5kKG1zZy5zZW5kZXIsIHRvLCB2YWx1ZSwgZGF0YSk7CiAgICAgICAgcmVxdWlyZShfY2hlY2tPbkJBQzAwMVJlY2VpdmVkKG1zZy5zZW5kZXIsIHRvLCB2YWx1ZSwgZGF0YSksICJCQUMwMDE6IHNlbmQgdG8gbm9uIEJBQzAwMVJlY2VpdmVyIGltcGxlbWVudGVyIik7CgogICAgfQoKLy8gICAgZnVuY3Rpb24gc2FmZVNlbmQoYWRkcmVzcyB0bywgdWludDI1NiB2YWx1ZSwgYnl0ZXMgZGF0YSkgcHVibGljIHdoZW5Ob3RTdXNwZW5kZWQgewovLyAgICAgICAgc2VuZCh0bywgdmFsdWUsIGRhdGEpOwovLyAgICAgICAgcmVxdWlyZShfY2hlY2tPbkJBQzAwMVJlY2VpdmVkKG1zZy5zZW5kZXIsIHRvLCB2YWx1ZSwgZGF0YSksICJCQUMwMDE6IHNlbmQgdG8gbm9uIEJBQzAwMVJlY2VpdmVyIGltcGxlbWVudGVyIik7Ci8vICAgIH0KCgogICAgLyoqCiAgICAgKiBAZGV2IEFwcHJvdmUgdGhlIHBhc3NlZCBhZGRyZXNzIHRvIHNwZW5kIHRoZSBzcGVjaWZpZWQgYW1vdW50IG9mIGFzc2V0cyBvbiBiZWhhbGYgb2YgbXNnLnNlbmRlci4KICAgICAqLwogICAgZnVuY3Rpb24gYXBwcm92ZShhZGRyZXNzIHNwZW5kZXIsIHVpbnQyNTYgdmFsdWUpIHB1YmxpYyB3aGVuTm90U3VzcGVuZGVkIHJldHVybnMgKGJvb2wpIHsKICAgICAgICBfYXBwcm92ZShtc2cuc2VuZGVyLCBzcGVuZGVyLCB2YWx1ZSk7CiAgICAgICAgcmV0dXJuIHRydWU7CiAgICB9CgogICAgLyoqCiAgICAgKiBAZGV2IFNlbmQgYXNzZXRzIGZyb20gb25lIGFkZHJlc3MgdG8gYW5vdGhlci4KICAgICAqLwogICAgZnVuY3Rpb24gc2VuZEZyb20oYWRkcmVzcyBmcm9tLCBhZGRyZXNzIHRvLCB1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKSBwdWJsaWMgd2hlbk5vdFN1c3BlbmRlZCB7CiAgICAgICAgX3NlbmQoZnJvbSwgdG8sIHZhbHVlLCBkYXRhKTsKICAgICAgICBfYXBwcm92ZShmcm9tLCBtc2cuc2VuZGVyLCBfYWxsb3dlZFtmcm9tXVttc2cuc2VuZGVyXS5zdWIodmFsdWUpKTsKICAgICAgICAvL2FkZAogICAgICAgIHJlcXVpcmUoX2NoZWNrT25CQUMwMDFSZWNlaXZlZChmcm9tLCB0bywgdmFsdWUsIGRhdGEpLCAiQkFDMDAxOiBzZW5kIHRvIG5vbiBCQUMwMDFSZWNlaXZlciBpbXBsZW1lbnRlciIpOwoKCiAgICB9CgovLy8vIHNhZmUgdG9kbwovLyAgICBmdW5jdGlvbiBzYWZlU2VuZEZyb20oYWRkcmVzcyBmcm9tLCBhZGRyZXNzIHRvLCB1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKSBwdWJsaWMgd2hlbk5vdFN1c3BlbmRlZCB7Ci8vICAgICAgICBzZW5kRnJvbShmcm9tLCB0bywgdmFsdWUsIGRhdGEpOwovLyAgICAgICAgcmVxdWlyZShfY2hlY2tPbkJBQzAwMVJlY2VpdmVkKGZyb20sIHRvLCB2YWx1ZSwgZGF0YSksICJCQUMwMDE6IHNlbmQgdG8gbm9uIEJBQzAwMVJlY2VpdmVyIGltcGxlbWVudGVyIik7Ci8vICAgIH0KCgogICAgZnVuY3Rpb24gYmF0Y2hTZW5kKGFkZHJlc3NbXSB0bywgdWludDI1NltdIHZhbHVlcywgYnl0ZXMgZGF0YSkgcHVibGljIHdoZW5Ob3RTdXNwZW5kZWQgewoKICAgICAgICAvLyBNVVNUIFRocm93IG9uIGVycm9ycwoKICAgICAgICByZXF1aXJlKHRvLmxlbmd0aCA9PSB2YWx1ZXMubGVuZ3RoLCAidG8gYW5kIHZhbHVlcyBhcnJheSBsZW5naHQgbXVzdCBtYXRjaC4iKTsKCiAgICAgICAgZm9yICh1aW50MjU2IGkgPSAwOyBpIDwgdG8ubGVuZ3RoOyArK2kpIHsKICAgICAgICAgICAgcmVxdWlyZSh0b1tpXSAhPSBhZGRyZXNzKDB4MCksICJkZXN0aW5hdGlvbiBhZGRyZXNzIG11c3QgYmUgbm9uLXplcm8uIik7CgogICAgICAgICAgICBzZW5kKHRvW2ldLCB2YWx1ZXNbaV0sIGRhdGEpOwogICAgICAgIH0KICAgIH0KCgogICAgZnVuY3Rpb24gX2NoZWNrT25CQUMwMDFSZWNlaXZlZChhZGRyZXNzIGZyb20sIGFkZHJlc3MgdG8sIHVpbnQyNTYgdmFsdWUsIGJ5dGVzIGRhdGEpCiAgICBpbnRlcm5hbCByZXR1cm5zIChib29sKQogICAgewogICAgICAgIGlmICghdG8uaXNDb250cmFjdCgpKSB7CiAgICAgICAgICAgIHJldHVybiB0cnVlOwogICAgICAgIH0KCiAgICAgICAgYnl0ZXM0IHJldHZhbCA9IElCQUMwMDFSZWNlaXZlcih0bykub25CQUMwMDFSZWNlaXZlZChmcm9tLCB0bywgdmFsdWUsIGRhdGEpOwogICAgICAgIHJldHVybiAocmV0dmFsID09IF9CQUMwMDFfUkVDRUlWRUQpOwogICAgfQoKICAgIC8qKgogICAgICogQGRldiBJbmNyZWFzZSB0aGUgYW1vdW50IG9mIGFzc2V0cyB0aGF0IGFuIG93bmVyIGFsbG93ZWQgdG8gYSBzcGVuZGVyLgogICAgICovCiAgICBmdW5jdGlvbiBpbmNyZWFzZUFsbG93YW5jZShhZGRyZXNzIHNwZW5kZXIsIHVpbnQyNTYgYWRkZWRWYWx1ZSkgcHVibGljIHdoZW5Ob3RTdXNwZW5kZWQgcmV0dXJucyAoYm9vbCkgewogICAgICAgIF9hcHByb3ZlKG1zZy5zZW5kZXIsIHNwZW5kZXIsIF9hbGxvd2VkW21zZy5zZW5kZXJdW3NwZW5kZXJdLmFkZChhZGRlZFZhbHVlKSk7CiAgICAgICAgcmV0dXJuIHRydWU7CiAgICB9CgogICAgLyoqCiAgICAgKiBAZGV2IERlY3JlYXNlIHRoZSBhbW91bnQgb2YgYXNzZXRzIHRoYXQgYW4gb3duZXIgYWxsb3dlZCB0byBhIHNwZW5kZXIuCiAgICAgKiBhcHByb3ZlIHNob3VsZCBiZSBjYWxsZWQgd2hlbiBfYWxsb3dlZFttc2cuc2VuZGVyXVtzcGVuZGVyXSA9PSAwLiBUbyBkZWNyZW1lbnQKICAgICAqLwogICAgZnVuY3Rpb24gZGVjcmVhc2VBbGxvd2FuY2UoYWRkcmVzcyBzcGVuZGVyLCB1aW50MjU2IHN1YnRyYWN0ZWRWYWx1ZSkgcHVibGljIHdoZW5Ob3RTdXNwZW5kZWQgcmV0dXJucyAoYm9vbCkgewogICAgICAgIF9hcHByb3ZlKG1zZy5zZW5kZXIsIHNwZW5kZXIsIF9hbGxvd2VkW21zZy5zZW5kZXJdW3NwZW5kZXJdLnN1YihzdWJ0cmFjdGVkVmFsdWUpKTsKICAgICAgICByZXR1cm4gdHJ1ZTsKICAgIH0KCiAgICBmdW5jdGlvbiBkZXN0cm95KHVpbnQyNTYgdmFsdWUsIGJ5dGVzIGRhdGEpIHB1YmxpYyB7CiAgICAgICAgX2Rlc3Ryb3kobXNnLnNlbmRlciwgdmFsdWUsIGRhdGEpOwogICAgfQoKICAgIC8qKgogICAgICogQGRldiBCdXJucyBhIHNwZWNpZmljIGFtb3VudCBvZiBhc3NldHMgZnJvbSB0aGUgdGFyZ2V0IGFkZHJlc3MgYW5kIGRlY3JlbWVudHMgYWxsb3dhbmNlLgogICAgICovCiAgICBmdW5jdGlvbiBkZXN0cm95RnJvbShhZGRyZXNzIGZyb20sIHVpbnQyNTYgdmFsdWUsIGJ5dGVzIGRhdGEpIHB1YmxpYyB7CiAgICAgICAgX2Rlc3Ryb3lGcm9tKGZyb20sIHZhbHVlLCBkYXRhKTsKICAgIH0KCgogICAgZnVuY3Rpb24gZGVzY3JpcHRpb24oKSBwdWJsaWMgdmlldyByZXR1cm5zIChzdHJpbmcgbWVtb3J5KSB7CiAgICAgICAgcmV0dXJuIF9kZXNjcmlwdGlvbjsKICAgIH0KCiAgICAvKioKICAgICAqIEByZXR1cm4gdGhlIHNob3J0TmFtZSBvZiB0aGUgYXNzZXQuCiAgICAgKi8KICAgIGZ1bmN0aW9uIHNob3J0TmFtZSgpIHB1YmxpYyB2aWV3IHJldHVybnMgKHN0cmluZyBtZW1vcnkpIHsKICAgICAgICByZXR1cm4gX3Nob3J0TmFtZTsKICAgIH0KCiAgICAvKioKICAgICAqIEByZXR1cm4gdGhlIG51bWJlciBvZiBtaW5Vbml0IG9mIHRoZSBhc3NldC4KICAgICAqLwogICAgZnVuY3Rpb24gbWluVW5pdCgpIHB1YmxpYyB2aWV3IHJldHVybnMgKHVpbnQ4KSB7CiAgICAgICAgcmV0dXJuIF9taW5Vbml0OwogICAgfQoKCiAgICBmdW5jdGlvbiBpc3N1ZShhZGRyZXNzIHRvLCB1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKSBwdWJsaWMgb25seUlzc3VlciByZXR1cm5zIChib29sKSB7CiAgICAgICAgX2lzc3VlKHRvLCB2YWx1ZSwgZGF0YSk7CiAgICAgICAgcmV0dXJuIHRydWU7CiAgICB9CiAgICAvKioKICAgICAqIEBkZXYgU2VuZCBhc3NldCBmb3IgYSBzcGVjaWZpZWQgYWRkcmVzc2VzLgogICAgICovCiAgICBmdW5jdGlvbiBfc2VuZChhZGRyZXNzIGZyb20sIGFkZHJlc3MgdG8sIHVpbnQyNTYgdmFsdWUsIGJ5dGVzIGRhdGEpIGludGVybmFsIHsKICAgICAgICByZXF1aXJlKHRvICE9IGFkZHJlc3MoMCksICJCQUMwMDE6IHNlbmQgdG8gdGhlIHplcm8gYWRkcmVzcyIpOwoKICAgICAgICBfYmFsYW5jZXNbZnJvbV0gPSBfYmFsYW5jZXNbZnJvbV0uc3ViKHZhbHVlKTsKICAgICAgICBfYmFsYW5jZXNbdG9dID0gX2JhbGFuY2VzW3RvXS5hZGQodmFsdWUpOwogICAgICAgIGVtaXQgU2VuZCggZnJvbSwgdG8sIHZhbHVlLCBkYXRhKTsKICAgIH0KCiAgICAvKioKICAgICAqIEBkZXYgSW50ZXJuYWwgZnVuY3Rpb24gdGhhdCBpc3N1ZXMgYW4gYW1vdW50IG9mIHRoZSBhc3NldCBhbmQgYXNzaWducyBpdCB0bwogICAgICovCiAgICBmdW5jdGlvbiBfaXNzdWUoYWRkcmVzcyBhY2NvdW50LCB1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKSBpbnRlcm5hbCB7CiAgICAgICAgcmVxdWlyZShhY2NvdW50ICE9IGFkZHJlc3MoMCksICJCQUMwMDE6IGlzc3VlIHRvIHRoZSB6ZXJvIGFkZHJlc3MiKTsKCiAgICAgICAgX3RvdGFsQW1vdW50ID0gX3RvdGFsQW1vdW50LmFkZCh2YWx1ZSk7CiAgICAgICAgX2JhbGFuY2VzW2FjY291bnRdID0gX2JhbGFuY2VzW2FjY291bnRdLmFkZCh2YWx1ZSk7CiAgICAgICAgZW1pdCBTZW5kKCBhZGRyZXNzKDApLCBhY2NvdW50LCB2YWx1ZSwgZGF0YSk7CiAgICB9CgogICAgLyoqCiAgICAgKiBAZGV2IEludGVybmFsIGZ1bmN0aW9uIHRoYXQgZGVzdHJveXMgYW4gYW1vdW50IG9mIHRoZSBhc3NldCBvZiBhIGdpdmVuCiAgICAgKi8KICAgIGZ1bmN0aW9uIF9kZXN0cm95KGFkZHJlc3MgYWNjb3VudCwgdWludDI1NiB2YWx1ZSwgYnl0ZXMgZGF0YSkgaW50ZXJuYWwgewogICAgICAgIHJlcXVpcmUoYWNjb3VudCAhPSBhZGRyZXNzKDApLCAiQkFDMDAxOiBkZXN0cm95IGZyb20gdGhlIHplcm8gYWRkcmVzcyIpOwoKICAgICAgICBfdG90YWxBbW91bnQgPSBfdG90YWxBbW91bnQuc3ViKHZhbHVlKTsKICAgICAgICBfYmFsYW5jZXNbYWNjb3VudF0gPSBfYmFsYW5jZXNbYWNjb3VudF0uc3ViKHZhbHVlKTsKICAgICAgICBlbWl0IFNlbmQoIGFjY291bnQsIGFkZHJlc3MoMCksIHZhbHVlLCBkYXRhKTsKICAgIH0KCiAgICAvKioKICAgICAqIEBkZXYgQXBwcm92ZSBhbiBhZGRyZXNzIHRvIHNwZW5kIGFub3RoZXIgYWRkcmVzc2VzJyBhc3NldHMuCiAgICAgKi8KICAgIGZ1bmN0aW9uIF9hcHByb3ZlKGFkZHJlc3Mgb3duZXIsIGFkZHJlc3Mgc3BlbmRlciwgdWludDI1NiB2YWx1ZSkgaW50ZXJuYWwgewogICAgICAgIHJlcXVpcmUob3duZXIgIT0gYWRkcmVzcygwKSwgIkJBQzAwMTogYXBwcm92ZSBmcm9tIHRoZSB6ZXJvIGFkZHJlc3MiKTsKICAgICAgICByZXF1aXJlKHNwZW5kZXIgIT0gYWRkcmVzcygwKSwgIkJBQzAwMTogYXBwcm92ZSB0byB0aGUgemVybyBhZGRyZXNzIik7CgogICAgICAgIF9hbGxvd2VkW293bmVyXVtzcGVuZGVyXSA9IHZhbHVlOwogICAgICAgIGVtaXQgQXBwcm92YWwoIG93bmVyLCBzcGVuZGVyLCB2YWx1ZSk7CiAgICB9CgogICAgLyoqCiAgICAgKiBAZGV2IEludGVybmFsIGZ1bmN0aW9uIHRoYXQgZGVzdHJveXMgYW4gYW1vdW50IG9mIHRoZSBhc3NldCBvZiBhIGdpdmVuCiAgICAgKi8KICAgIGZ1bmN0aW9uIF9kZXN0cm95RnJvbShhZGRyZXNzIGFjY291bnQsIHVpbnQyNTYgdmFsdWUsIGJ5dGVzIGRhdGEpIGludGVybmFsIHsKICAgICAgICBfZGVzdHJveShhY2NvdW50LCB2YWx1ZSwgZGF0YSk7CiAgICAgICAgX2FwcHJvdmUoYWNjb3VudCwgbXNnLnNlbmRlciwgX2FsbG93ZWRbYWNjb3VudF1bbXNnLnNlbmRlcl0uc3ViKHZhbHVlKSk7CiAgICB9Cn0KCg==",
                "BAC001","BAC001");
        insertContractItem(contractIndex++,pointsId,"IBAC001","cHJhZ21hIHNvbGlkaXR5IF4wLjQuMjU7CgoKaW50ZXJmYWNlIElCQUMwMDEgewoKICAgIGZ1bmN0aW9uIHRvdGFsQW1vdW50KCkgcHVibGljIHZpZXcgcmV0dXJucyAodWludDI1Nik7CgogICAgZnVuY3Rpb24gYmFsYW5jZShhZGRyZXNzIG93bmVyKSBwdWJsaWMgdmlldyByZXR1cm5zICh1aW50MjU2KTsKCiAgICBmdW5jdGlvbiBzZW5kKGFkZHJlc3MgdG8sIHVpbnQyNTYgdmFsdWUsIGJ5dGVzIGRhdGEpIHB1YmxpYyA7CgogICAgZnVuY3Rpb24gc2VuZEZyb20oYWRkcmVzcyBmcm9tLCBhZGRyZXNzIHRvLCB1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKSBwdWJsaWM7CgogICAgZnVuY3Rpb24gYWxsb3dhbmNlKGFkZHJlc3Mgb3duZXIsIGFkZHJlc3Mgc3BlbmRlcikgcHVibGljIHZpZXcgcmV0dXJucyAodWludDI1Nik7CgogICAgZnVuY3Rpb24gYXBwcm92ZShhZGRyZXNzIHNwZW5kZXIsIHVpbnQyNTYgYW1vdW50KSBwdWJsaWMgcmV0dXJucyAoYm9vbCk7CgogICAgZnVuY3Rpb24gZGVzdHJveSh1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKSBwdWJsaWM7CgogICAgZnVuY3Rpb24gZGVzdHJveUZyb20oYWRkcmVzcyBmcm9tLCB1aW50MjU2IHZhbHVlLCBieXRlcyBkYXRhKSBwdWJsaWM7CgogICAgZnVuY3Rpb24gaXNzdWUoYWRkcmVzcyB0bywgdWludDI1NiB2YWx1ZSwgYnl0ZXMgZGF0YSkgcHVibGljICByZXR1cm5zIChib29sKTsKCiAgICBmdW5jdGlvbiBiYXRjaFNlbmQoYWRkcmVzc1tdIHRvLCB1aW50MjU2W10gdmFsdWVzLCBieXRlcyBkYXRhKSBwdWJsaWM7CgogICAgZnVuY3Rpb24gaW5jcmVhc2VBbGxvd2FuY2UoYWRkcmVzcyBzcGVuZGVyLCB1aW50MjU2IGFkZGVkVmFsdWUpIHB1YmxpYyAgcmV0dXJucyAoYm9vbCk7CgogICAgZnVuY3Rpb24gZGVjcmVhc2VBbGxvd2FuY2UoYWRkcmVzcyBzcGVuZGVyLCB1aW50MjU2IHN1YnRyYWN0ZWRWYWx1ZSkgcHVibGljICByZXR1cm5zIChib29sKTsKCiAgICBldmVudCBTZW5kKGFkZHJlc3MgaW5kZXhlZCBmcm9tLCBhZGRyZXNzIGluZGV4ZWQgdG8sIHVpbnQyNTYgdmFsdWUsIGJ5dGVzIGRhdGEpOwoKICAgIGV2ZW50IEFwcHJvdmFsKGFkZHJlc3MgaW5kZXhlZCBvd25lciwgYWRkcmVzcyBpbmRleGVkIHNwZW5kZXIsIHVpbnQyNTYgdmFsdWUpOwoKfQ",
                "IBAC001","IBAC001");
        insertContractItem(contractIndex++,pointsId,"Roles","cHJhZ21hIHNvbGlkaXR5IF4wLjQuMjU7CgpsaWJyYXJ5IFJvbGVzIHsKICAgIHN0cnVjdCBSb2xlIHsKICAgICAgICBtYXBwaW5nIChhZGRyZXNzID0+IGJvb2wpIGJlYXJlcjsKICAgIH0KCiAgICBmdW5jdGlvbiBhZGQoUm9sZSBzdG9yYWdlIHJvbGUsIGFkZHJlc3MgYWNjb3VudCkgaW50ZXJuYWwgewogICAgICAgIHJlcXVpcmUoIWhhcyhyb2xlLCBhY2NvdW50KSwgIlJvbGVzOiBhY2NvdW50IGFscmVhZHkgaGFzIHJvbGUiKTsKICAgICAgICByb2xlLmJlYXJlclthY2NvdW50XSA9IHRydWU7CiAgICB9CgogICAgZnVuY3Rpb24gcmVtb3ZlKFJvbGUgc3RvcmFnZSByb2xlLCBhZGRyZXNzIGFjY291bnQpIGludGVybmFsIHsKICAgICAgICByZXF1aXJlKGhhcyhyb2xlLCBhY2NvdW50KSwgIlJvbGVzOiBhY2NvdW50IGRvZXMgbm90IGhhdmUgcm9sZSIpOwogICAgICAgIHJvbGUuYmVhcmVyW2FjY291bnRdID0gZmFsc2U7CiAgICB9CgogICAgZnVuY3Rpb24gaGFzKFJvbGUgc3RvcmFnZSByb2xlLCBhZGRyZXNzIGFjY291bnQpIGludGVybmFsIHZpZXcgcmV0dXJucyAoYm9vbCkgewogICAgICAgIHJlcXVpcmUoYWNjb3VudCAhPSBhZGRyZXNzKDApLCAiUm9sZXM6IGFjY291bnQgaXMgdGhlIHplcm8gYWRkcmVzcyIpOwogICAgICAgIHJldHVybiByb2xlLmJlYXJlclthY2NvdW50XTsKICAgIH0KfQo=",
                "Roles","Roles");
        insertContractItem(contractIndex++,pointsId,"SafeMath","cHJhZ21hIHNvbGlkaXR5IF4wLjQuMjU7CgoKbGlicmFyeSBTYWZlTWF0aCB7CiAgICBmdW5jdGlvbiBtdWwodWludDI1NiBhLCB1aW50MjU2IGIpIGludGVybmFsIHB1cmUgcmV0dXJucyAodWludDI1NikgewogICAgICAgIC8vIEdhcyBvcHRpbWl6YXRpb246IHRoaXMgaXMgY2hlYXBlciB0aGFuIHJlcXVpcmluZyAnYScgbm90IGJlaW5nIHplcm8sIGJ1dCB0aGUKICAgICAgICAvLyBiZW5lZml0IGlzIGxvc3QgaWYgJ2InIGlzIGFsc28gdGVzdGVkLgogICAgICAgIC8vIFNlZTogaHR0cHM6Ly9naXRodWIuY29tL09wZW5aZXBwZWxpbi9vcGVuemVwcGVsaW4tc29saWRpdHkvcHVsbC81MjIKICAgICAgICBpZiAoYSA9PSAwKSB7CiAgICAgICAgICAgIHJldHVybiAwOwogICAgICAgIH0KCiAgICAgICAgdWludDI1NiBjID0gYSAqIGI7CiAgICAgICAgcmVxdWlyZShjIC8gYSA9PSBiLCAiU2FmZU1hdGg6IG11bHRpcGxpY2F0aW9uIG92ZXJmbG93Iik7CgogICAgICAgIHJldHVybiBjOwogICAgfQogICAgZnVuY3Rpb24gZGl2KHVpbnQyNTYgYSwgdWludDI1NiBiKSBpbnRlcm5hbCBwdXJlIHJldHVybnMgKHVpbnQyNTYpIHsKICAgICAgICAvLyBTb2xpZGl0eSBvbmx5IGF1dG9tYXRpY2FsbHkgYXNzZXJ0cyB3aGVuIGRpdmlkaW5nIGJ5IDAKICAgICAgICByZXF1aXJlKGIgPiAwLCAiU2FmZU1hdGg6IGRpdmlzaW9uIGJ5IHplcm8iKTsKICAgICAgICB1aW50MjU2IGMgPSBhIC8gYjsKICAgICAgICAvLyBhc3NlcnQoYSA9PSBiICogYyArIGEgJSBiKTsgLy8gVGhlcmUgaXMgbm8gY2FzZSBpbiB3aGljaCB0aGlzIGRvZXNuJ3QgaG9sZAoKICAgICAgICByZXR1cm4gYzsKICAgIH0KICAgIGZ1bmN0aW9uIHN1Yih1aW50MjU2IGEsIHVpbnQyNTYgYikgaW50ZXJuYWwgcHVyZSByZXR1cm5zICh1aW50MjU2KSB7CiAgICAgICAgcmVxdWlyZShiIDw9IGEsICJTYWZlTWF0aDogc3VidHJhY3Rpb24gb3ZlcmZsb3ciKTsKICAgICAgICB1aW50MjU2IGMgPSBhIC0gYjsKCiAgICAgICAgcmV0dXJuIGM7CiAgICB9CiAgICBmdW5jdGlvbiBhZGQodWludDI1NiBhLCB1aW50MjU2IGIpIGludGVybmFsIHB1cmUgcmV0dXJucyAodWludDI1NikgewogICAgICAgIHVpbnQyNTYgYyA9IGEgKyBiOwogICAgICAgIHJlcXVpcmUoYyA+PSBhLCAiU2FmZU1hdGg6IGFkZGl0aW9uIG92ZXJmbG93Iik7CgogICAgICAgIHJldHVybiBjOwogICAgfQogICAgZnVuY3Rpb24gbW9kKHVpbnQyNTYgYSwgdWludDI1NiBiKSBpbnRlcm5hbCBwdXJlIHJldHVybnMgKHVpbnQyNTYpIHsKICAgICAgICByZXF1aXJlKGIgIT0gMCwgIlNhZmVNYXRoOiBtb2R1bG8gYnkgemVybyIpOwogICAgICAgIHJldHVybiBhICUgYjsKICAgIH0KfQo=",
                "SafeMath","SafeMath");
    }


    public void insertContractItem(long contractId, long contractFolderId, String contractName, String contractSrc,
                                String contractDesc, String contractDesc_en)
    {
        ContractItem contractItem = new ContractItem();
        contractItem.setContractId(contractId);
        contractItem.setContractFolderId(contractFolderId);
        contractItem.setContractName(contractName);
        contractItem.setContractSrc(contractSrc);
        contractItem.setContractDesc(contractDesc);
        contractItem.setContractDesc_en(contractDesc_en);
        contractItem.setCreateTime(LocalDateTime.now());
        contractItem.setModifyTime(contractItem.getCreateTime());
        contractItemRepository.save(contractItem);
    }

    public void initPresetData()
    {
        List<ContractItem> contracts = contractItemRepository.findAll();
        if(contracts.size() <= 0)
        {
            initContractItem();
        }

        List<ContractFolderItem> contractFolderItemList = contractFolderRepository.findAll();
        if(contractFolderItemList.size() <= 0)
        {
            initContractFolderItem();
        }

        List<StoreItem> storeItemList = contractStoreRepository.findAll();
        if(storeItemList.size() <= 0)
        {
            initStoreItem();
        }
    }

}
